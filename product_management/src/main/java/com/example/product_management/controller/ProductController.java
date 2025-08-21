package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.model.ProductDTO;
import com.example.product_management.service.IProductService;
import com.example.product_management.service.IProductTypeService;
import com.example.product_management.service.ProductService;
import com.example.product_management.service.ProductTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/product-list")
public class ProductController extends HttpServlet {
    IProductService productService = new ProductService();
    IProductTypeService productTypeService = new ProductTypeService();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        String action = req.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "":
//                searchByName(req,resp);
//                break;
//            case "add":
//                showFormAdd(req,resp);
//                break;
//
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                showFormAdd(req, resp);
                break;
            default:
                showProductList(req, resp);
                break;
        }
    }


    public void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("listProductType", productTypeService.getProductTypeList());
        try {
            req.getRequestDispatcher("/WEB-INF/product-add.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showProductList(HttpServletRequest req, HttpServletResponse resp) {
        String keyword = req.getParameter("search");
        List<ProductDTO> products;

        if (keyword != null && !keyword.trim().isEmpty()) {
            products = productService.getProductByName(keyword);
        } else {
            products = productService.getAllProducts();
        }

        // Truyền cả loại sản phẩm cho modal
        req.setAttribute("productList", products);
        req.setAttribute("listProductType", productTypeService.getProductTypeList());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product-list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


//    public void showProductList(HttpServletRequest req, HttpServletResponse resp) {
//        String keyword = req.getParameter("search");
//        List<ProductDTO> products;
//
//        if (keyword != null && !keyword.trim().isEmpty()) {
//            products = productService.getProductByName(keyword);
//        } else {
//            products = productService.getAllProducts();
//        }
//
//        req.setAttribute("productList", products);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product-list.jsp");
//        try {
//            dispatcher.forward(req, resp);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        switch (action) {
            case "add":
                boolean isSuccess = addProduct(req);
                resp.sendRedirect(req.getContextPath() + "/product-list");
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("productId"));
                deleteProduct(id);
                resp.sendRedirect(req.getContextPath() + "/product-list");
                break;
            case "edit":
                int prodId = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                double price = Float.parseFloat(req.getParameter("price"));
                int stock = Integer.parseInt(req.getParameter("stock"));
                int typeId = Integer.parseInt(req.getParameter("typeId"));
                updateProduct(prodId, name, price, stock, typeId);
                resp.sendRedirect(req.getContextPath() + "/product-list");

        }
    }

//    public boolean addProduct(HttpServletRequest req) {
//        String name = req.getParameter("name");
//        int typeId = req.getParameter("productType") == null ? 0 : Integer.parseInt(req.getParameter("productType"));
//        double price = req.getParameter("price") == null ? 0.0 : Double.parseDouble(req.getParameter("price"));
//        int stock = req.getParameter("stock") == null ? 0 : Integer.parseInt(req.getParameter("stock"));
//        if (name != null && price > 0 && stock >= 0) {
//            Product tempProduct = new Product( name, price, stock, typeId);
//            productService.addProduct(tempProduct);
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean addProduct(HttpServletRequest req) {
        String name = req.getParameter("name");
        int typeId = req.getParameter("productType") == null ? 0 : Integer.parseInt(req.getParameter("productType"));
        double price = req.getParameter("price") == null ? 0.0 : Double.parseDouble(req.getParameter("price"));
        int stock = req.getParameter("stock") == null ? 0 : Integer.parseInt(req.getParameter("stock"));

        if (name != null && price > 0 && stock >= 0 && typeId > 0) {
            Product tempProduct = new Product(name, price, stock, typeId);
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

    public boolean updateProduct(int id, String name, double price, int stock, int typeId) {
        if (id > 0){
            return productService.updateProduct(id, name, price, stock, typeId);
        }
        return false;
    }

    public List<ProductDTO> searchProduct(String name){
        return productService.getProductByName(name);
    }
}
