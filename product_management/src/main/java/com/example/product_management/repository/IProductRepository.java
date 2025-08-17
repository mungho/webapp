package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    public boolean addProduct(Product product);
    public boolean updateProduct(int id, String name, double price, int stock);
    public boolean deleteProduct(int id);
    public List<Product> getProductByName(String name);
    public List<Product> getAllProducts();
}
