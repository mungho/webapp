package com.example.bai10.customer_list.controller;

import com.example.bai10.customer_list.controller.model.Customer;
import com.example.bai10.customer_list.controller.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "")
public class CustomerController extends HttpServlet {
    CustomerService customerService = new CustomerService();
    List<Customer> customers = customerService.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
