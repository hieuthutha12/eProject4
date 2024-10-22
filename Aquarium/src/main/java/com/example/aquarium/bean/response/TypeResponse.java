package com.example.aquarium.bean.response;

import java.math.BigDecimal;

public class TypeResponse {
    private Integer id;
    private BigDecimal price;
    private String typeName;
    private String description;
    private String status;

    public TypeResponse() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
}
