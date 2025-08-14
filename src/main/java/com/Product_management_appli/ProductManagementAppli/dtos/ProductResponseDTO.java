package com.Product_management_appli.ProductManagementAppli.dtos;

import com.Product_management_appli.ProductManagementAppli.entity.ProductType;

public class ProductResponseDTO {

    private long id;
    private String name;
    private double price;
    private int stockQuantity;
    private ProductType type;
    private String message;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(long id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
