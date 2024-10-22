package com.example.aquarium.bean.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TypeRequest {

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotBlank(message = "Type name is mandatory")
    @Size(max = 20, message = "Type name must not exceed 20 characters")
    private String typeName;

    @Size(max = 100, message = "Description must not exceed 100 characters")
    private String description;

    @NotBlank(message = "Status is mandatory")
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Status must be either ACTIVE or INACTIVE")
    private String status;


    public TypeRequest() {
    }

    public @NotNull(message = "Price is mandatory") @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero") BigDecimal getPrice() {
        return price;
    }


    public @NotBlank(message = "Type name is mandatory") @Size(max = 20, message = "Type name must not exceed 20 characters") String getTypeName() {
        return typeName;
    }



    public @Size(max = 100, message = "Description must not exceed 100 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 100, message = "Description must not exceed 100 characters") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Status is mandatory") @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Status must be either ACTIVE or INACTIVE") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status is mandatory") @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Status must be either ACTIVE or INACTIVE") String status) {
        this.status = status;
    }
}

