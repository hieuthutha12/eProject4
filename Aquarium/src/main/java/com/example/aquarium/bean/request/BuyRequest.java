package com.example.aquarium.bean.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class BuyRequest {
    @NotNull(message = "User ID is mandatory")
    private Integer userId;

    @NotNull(message = "Total amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than zero")
    private BigDecimal totalAmount;

    @NotBlank(message = "Status is mandatory")
    @Size(max = 50, message = "Status must not exceed 50 characters")
    private String status;

    @NotBlank(message = "Payment method is mandatory")
    @Size(max = 50, message = "Payment method must not exceed 50 characters")
    private String paymentMethod;

    @DecimalMin(value = "0.0", message = "Discount cannot be negative")
    private BigDecimal discount;

    private List<OrderDetailsRequest> orderDetailsRequests;

    public BuyRequest(Integer userId, BigDecimal totalAmount, String status, String paymentMethod, BigDecimal discount, List<OrderDetailsRequest> orderDetailsRequests) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.orderDetailsRequests = orderDetailsRequests;
    }

    public BuyRequest() {
    }

    public @NotNull(message = "User ID is mandatory") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID is mandatory") Integer userId) {
        this.userId = userId;
    }

    public @NotNull(message = "Total amount is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than zero") BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(@NotNull(message = "Total amount is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than zero") BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public @NotBlank(message = "Payment method is mandatory") @Size(max = 50, message = "Payment method must not exceed 50 characters") String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NotBlank(message = "Payment method is mandatory") @Size(max = 50, message = "Payment method must not exceed 50 characters") String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public @NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String status) {
        this.status = status;
    }

    public @DecimalMin(value = "0.0", message = "Discount cannot be negative") BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(@DecimalMin(value = "0.0", message = "Discount cannot be negative") BigDecimal discount) {
        this.discount = discount;
    }

    public List<OrderDetailsRequest> getOrderDetailsRequests() {
        return orderDetailsRequests;
    }

    public void setOrderDetailsRequests(List<OrderDetailsRequest> orderDetailsRequests) {
        this.orderDetailsRequests = orderDetailsRequests;
    }
}
