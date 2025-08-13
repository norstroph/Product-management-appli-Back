package com.Product_management_appli.ProductManagementAppli.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarRequestDTO {
    @NotBlank(message = "brand cant be null")
    private String brand;
    @NotBlank(message = "model cant be null")
    private String model;
    @NotNull(message = "price cant be null")
    private double price;

    public CarRequestDTO() {
    }
    public CarRequestDTO(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
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
}
