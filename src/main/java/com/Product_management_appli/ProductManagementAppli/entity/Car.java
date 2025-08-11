package com.Product_management_appli.ProductManagementAppli.entity;

public class Car {
    private long id;
    private String brand;
    private String model;
    private double price;
    private int stock_quantity;

    public Car() {
    }
    public Car(long id, String brand, String model, double price, int stock_quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock_quantity = stock_quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
}
