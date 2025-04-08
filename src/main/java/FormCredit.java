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

public class FormCredit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        try {
            ArrayList<Credit> credits =  CreditDAO.findAll();
            req.setAttribute("credits", credits); 
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        RequestDispatcher dispat = req.getRequestDispatcher("depense.jsp");
        dispat.forward(req,res);
    }
}