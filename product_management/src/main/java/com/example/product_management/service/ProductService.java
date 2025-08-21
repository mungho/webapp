package com.example.product_management.service;

import com.example.product_management.model.Product;
import com.example.product_management.model.ProductDTO;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    IProductRepository productRepository = new ProductRepository();

    @Override
    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(int id, String name, double price, int stock,int typeId) {
        return productRepository.updateProduct(id, name, price, stock, typeId);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
