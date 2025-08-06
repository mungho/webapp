package com.example.demo5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Discount Calculator", value = "/discount-calculator")
public class DiscountCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productDesc = req.getParameter("productDescription");
        double listPrice = Double.parseDouble(req.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(req.getParameter("discountPercent"));

        double discountAmount = listPrice * discountPercent / 100;
        double finalPrice = listPrice - discountAmount;

        req.setAttribute("productDesc", productDesc);
        req.setAttribute("listPrice", listPrice);
        req.setAttribute("discountPercent", discountPercent);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("finalPrice", finalPrice);
        req.getRequestDispatcher("WEB-INF/displayResult.jsp").forward(req, resp);
    }
}
