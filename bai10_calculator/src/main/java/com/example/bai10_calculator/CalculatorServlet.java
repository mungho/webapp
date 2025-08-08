package com.example.bai10_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operator = req.getParameter("operator");
        int firstOperand = Integer.parseInt(req.getParameter("firstOperand"));
        int secondOperand = Integer.parseInt(req.getParameter("secondOperand"));
        int result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand/secondOperand;
                break;
        }
        req.setAttribute("result", result);
        req.setAttribute("firstOperand", firstOperand);
        req.setAttribute("secondOperand", secondOperand);
        req.setAttribute("operator", operator);
        req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
    }
}
