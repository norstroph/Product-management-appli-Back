package com.Product_management_appli.ProductManagementAppli.entity;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private LocalDateTime date;
    private Long customerId;

    public Order() {
    }

    public Order(Long id, LocalDateTime date, Long customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
