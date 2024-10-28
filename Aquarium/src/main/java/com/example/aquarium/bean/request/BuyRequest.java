package com.example.aquarium.bean.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
