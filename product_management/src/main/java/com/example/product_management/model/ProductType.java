package com.example.product_management.model;

public class ProductType {
    int id;
    String name;

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductType() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
