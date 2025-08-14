package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import com.example.product_management.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productController", value = "/product-list")
public class ProductController extends HttpServlet {
    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", productService.getAllProducts());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product-list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                boolean isSuccess = addProduct(req);
                resp.sendRedirect(req.getContextPath() + "/product-list?added=1");
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("productId"));
                deleteProduct(id);
                resp.sendRedirect(req.getContextPath() + "/product-list");
//                String idRaw = req.getParameter("productId");   // <-- khớp với input hidden name="id"
//                int id = -1;
//                try {
//                    id = Integer.parseInt(idRaw);
//                } catch (Exception ignored) {}
//
//                boolean ok = (id > 0) && deleteProduct(id);
//                resp.sendRedirect(req.getContextPath() + "/product-list?deleted=" + (ok ? "1" : "0"));
                break;
        }
    }

    public boolean addProduct(HttpServletRequest req) {
        String name = req.getParameter("name");
        double price = req.getParameter("price") == null ? 0.0 : Double.parseDouble(req.getParameter("price"));
        int stock = req.getParameter("stock") == null ? 0 : Integer.parseInt(req.getParameter("stock"));
        if (name != null && price > 0 && stock >= 0) {
            Product tempProduct = new Product(name, price, stock);
            productService.addProduct(tempProduct);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(int id){
       if (id > 0) {
           return productService.deleteProduct(id);
       }
       return false;
    }
}
