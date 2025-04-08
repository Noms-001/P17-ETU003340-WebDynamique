package controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.ServletException;
import models.Depense;
import dao.DepenseDAO;
import dao.CreditDAO;

public class DepenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String libelle = req.getParameter("libelle");
        int credit = Integer.parseInt(req.getParameter("credit"));
        double montant = Double.parseDouble(req.getParameter("montant"));
        try {
            Depense depense = new Depense(libelle, credit, montant);
            if(CreditDAO.getReste(depense.getCredit()) >= montant) {
                DepenseDAO.save(depense);
            } else {
                req.setAttribute("erreur", "solde depasse");
            }
        } catch(Exception e) {
            throw new ServletException(e.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("formcredit");
        dispat.forward(req,res);
    }


}