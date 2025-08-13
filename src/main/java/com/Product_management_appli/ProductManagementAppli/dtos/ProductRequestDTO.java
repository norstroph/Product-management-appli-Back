package com.Product_management_appli.ProductManagementAppli.dtos;

import com.Product_management_appli.ProductManagementAppli.entity.ProductType;

public class ProductRequestDTO {

    private String name;
    private double price;
    private int stockQuantity;
    private ProductType type;

    public ProductRequestDTO() {
    }
    public ProductRequestDTO(String name, double price, int stockQuantity, ProductType type) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
