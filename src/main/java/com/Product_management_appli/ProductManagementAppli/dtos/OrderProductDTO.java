package com.Product_management_appli.ProductManagementAppli.dtos;

public class OrderProductDTO {
    private Long id;

    public OrderProductDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
