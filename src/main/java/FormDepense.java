package controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.ServletException;
import dao.CreditDAO;
import models.Credit;
import java.util.ArrayList;

public class FormDepense extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        try {
            ArrayList<Credit> credits =  CreditDAO.findAll();
            req.setAttribute("credits", credits); 
            ArrayList<Double> restes = new ArrayList<>();
            ArrayList<Double> depenses = new ArrayList<>();
            for(Credit credit : credits) {
                depenses.add(CreditDAO.getDepense(credit.getId()));
                restes.add(CreditDAO.getReste(credit.getId()));
            }
            req.setAttribute("restes", restes);
            req.setAttribute("depenses", depenses);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("dashboard.jsp");
        dispat.forward(req,res);
    }
}