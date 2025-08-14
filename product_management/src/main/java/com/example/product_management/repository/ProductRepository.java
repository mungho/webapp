package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("Banana", 1.2, 100));
        productList.add(new Product("Mango", 2.0, 100));
        productList.add(new Product("Apple", 1.5, 80));
        productList.add(new Product("Orange", 1.8, 90));
        productList.add(new Product("Grapes", 2.5, 70));
        productList.add(new Product("Pineapple", 3.0, 50));
        productList.add(new Product("Watermelon", 4.0, 30));
        productList.add(new Product("Papaya", 2.2, 60));
        productList.add(new Product("Strawberry", 5.0, 40));
        productList.add(new Product("Blueberry", 6.0, 35));
        productList.add(new Product("Kiwi", 2.8, 55));
        productList.add(new Product("Peach", 3.2, 45));
    }

    @Override
    public boolean addProduct(Product product) {
        if (product.getName() != null && product.getPrice() > 0 && product.getStock() >= 0) {
            productList.add(product);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        if (getProductByID(id) == null) {
            return false;
        } else {
            productList.remove(getProductByID(id));
            return true;
        }
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productList;
    }

    public Product getProductByID(int id) {
        for (Product product : productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}
