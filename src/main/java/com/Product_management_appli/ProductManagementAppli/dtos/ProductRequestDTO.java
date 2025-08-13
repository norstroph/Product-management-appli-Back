package com.Product_management_appli.ProductManagementAppli.dtos;

import com.Product_management_appli.ProductManagementAppli.entity.ProductType;

public class ProductRequestDTO {

    private String name;
    private double price;
    private int stock_quantity;
    private ProductType type;

    public ProductRequestDTO() {
    }
    public ProductRequestDTO(String name, double price, int stock_quantity, ProductType type) {
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
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
