package com.example.product_management.model;

public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int typeId;

    public Product(int id, String name, double price, int stock, int typeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.typeId = typeId;
    }

    public Product(String name, double price, int stock, int typeId) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.typeId = typeId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
