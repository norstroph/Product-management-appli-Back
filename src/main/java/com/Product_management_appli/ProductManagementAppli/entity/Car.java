package com.Product_management_appli.ProductManagementAppli.entity;

import jakarta.validation.constraints.Min;

public class Car {
    private Long id;
    private String brand;
    private String model;
    private double price;
    @Min(1)
    private int stockQuantity;

    public Car() {
    }
    public Car(Long id, String brand, String model, double price, int stockQuantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
