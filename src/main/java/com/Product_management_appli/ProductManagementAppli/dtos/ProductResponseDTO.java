package com.Product_management_appli.ProductManagementAppli.dtos;

import com.Product_management_appli.ProductManagementAppli.entity.ProductType;

public class ProductResponseDTO {
    private String name;
    private double price;
    private int stockQuantity;
    private ProductType type;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String name, int stockQuantity, double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public ProductResponseDTO(String name, ProductType type, int stockQuantity, double price) {
        this.name = name;
        this.type = type;
        this.stockQuantity = stockQuantity;
        this.price = price;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
