package com.example.aquarium.bean.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OrderRequest {

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

    public OrderRequest() {
    }

    public @NotNull(message = "User ID is mandatory") Integer getUserId() {
        return userId;
    }


    public @NotNull(message = "Total amount is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than zero") BigDecimal getTotalAmount() {
        return totalAmount;
    }


    public @NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String status) {
        this.status = status;
    }

    public @NotBlank(message = "Payment method is mandatory") @Size(max = 50, message = "Payment method must not exceed 50 characters") String getPaymentMethod() {
        return paymentMethod;
    }


    public @DecimalMin(value = "0.0", message = "Discount cannot be negative") BigDecimal getDiscount() {
        return discount;
    }


}

