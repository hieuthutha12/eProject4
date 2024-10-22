package com.example.aquarium.bean.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketResponse {
    private Integer id;
    private LocalDateTime purchaseDate;
    private LocalDateTime expirationDate;
    private String status;
    private String typeName;

    public TicketResponse() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getStatus() {
        return status;
    }
}