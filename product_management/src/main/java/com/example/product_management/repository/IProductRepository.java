package com.example.product_management.repository;

import com.example.product_management.model.Product;
import com.example.product_management.model.ProductDTO;

import java.util.List;

public interface IProductRepository {
    public boolean addProduct(Product product);
    public boolean updateProduct(int id, String name, double price, int stock, int typeId);
    public boolean deleteProduct(int id);
    public List<ProductDTO> getProductByName(String name);
    public List<ProductDTO> getAllProducts();
}
