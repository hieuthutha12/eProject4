package com.example.aquarium.bean.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderResponse {
    private Integer id;
    private Integer userId;
    private BigDecimal totalAmount;
    private String status;
    private String paymentMethod;
    private BigDecimal discount;
    private Timestamp createdAt;

    public OrderResponse() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}

