package com.example.aquarium.bean.response;

import java.math.BigDecimal;

public class OrderDetailsResponse {
    private Integer ticketId;
    private Integer orderId;
    private BigDecimal price;
    private Integer quantity;

    public OrderDetailsResponse() {
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
