package controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.ServletException;
import models.Credit;
import dao.CreditDAO;

public class CreditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String libelle = req.getParameter("libelle");
        double montant = Double.parseDouble(req.getParameter("montant"));
        try {
            Credit credit = new Credit(libelle, montant);
            CreditDAO.save(credit);
        } catch(Exception e) {
            throw new ServletException(e.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("index.html");
        dispat.forward(req,res);
    }


}