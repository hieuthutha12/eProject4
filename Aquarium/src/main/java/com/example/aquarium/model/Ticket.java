package com.example.aquarium.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "status", length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "order_details_id", nullable = false)
    private OrderDetails orderDetails;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Ticket(Integer id, LocalDateTime purchaseDate, LocalDateTime expirationDate, String status, OrderDetails orderDetails, Type type) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.status = status;
        this.orderDetails = orderDetails;
        this.type = type;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

