package com.example.product_management.model;

public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product() {
        this.id = idCounter++;
    }

    public Product(String name, double price, int stock) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
