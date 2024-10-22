package com.example.aquarium.bean.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetailsRequest {

    private Integer orderId;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    private List<TicketRequest> ticketRequest;

    public List<TicketRequest> getTicketRequest() {
        return ticketRequest;
    }

    public void setTicketRequest(List<TicketRequest> ticketRequest) {
        this.ticketRequest = ticketRequest;
    }

    public OrderDetailsRequest() {
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public @NotNull(message = "Price is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero") BigDecimal price) {
        this.price = price;
    }

}
