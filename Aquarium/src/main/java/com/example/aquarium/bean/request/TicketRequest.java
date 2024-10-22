package com.example.aquarium.bean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketRequest {

    @NotNull(message = "Purchase date is mandatory")
    private LocalDateTime purchaseDate;

    @NotNull(message = "Expiration date is mandatory")
    private LocalDateTime expirationDate;

    @NotBlank(message = "Status is mandatory")
    @Size(max = 50, message = "Status must not exceed 50 characters")
    private String status;

    @NotNull(message = "Type ID is mandatory")
    private Integer typeId;

    public TicketRequest(LocalDateTime purchaseDate, LocalDateTime expirationDate, String status, Integer typeId) {
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.status = status;
        this.typeId = typeId;
    }
    public TicketRequest() {
    }

    public @NotNull(message = "Purchase date is mandatory") LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(@NotNull(message = "Purchase date is mandatory") LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public @NotNull(message = "Expiration date is mandatory") LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@NotNull(message = "Expiration date is mandatory") LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public @NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is mandatory") @Size(max = 50, message = "Status must not exceed 50 characters") String status) {
        this.status = status;
    }

    public @NotNull(message = "Type ID is mandatory") Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(@NotNull(message = "Type ID is mandatory") Integer typeId) {
        this.typeId = typeId;
    }
}
