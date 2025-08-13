package com.Product_management_appli.ProductManagementAppli.dtos;

public class ProductResponseDTO {
    private String name;
    private double price;
    private int stock_quantity;

    public ProductResponseDTO() {
    }
    public ProductResponseDTO(String name, int stock_quantity, double price) {
        this.name = name;
        this.stock_quantity = stock_quantity;
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

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
}
