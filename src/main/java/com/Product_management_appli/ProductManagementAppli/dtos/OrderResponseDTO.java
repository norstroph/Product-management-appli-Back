package com.Product_management_appli.ProductManagementAppli.dtos;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private LocalDateTime date;
    private Long customerId;

    public OrderResponseDTO() {
    }
    public OrderResponseDTO(LocalDateTime date, Long customerId) {
        this.date = date;
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
