package com.example.aquarium.bean.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AreaRequest {

    @NotBlank(message = "Area name is required")
    @Size(max = 100, message = "Area name must not exceed 100 characters")
    private String areaName;

    @NotBlank(message = "Environment type is required")
    @Size(max = 50, message = "Environment type must not exceed 50 characters")
    private String environmentType;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    public AreaRequest() {
    }


    public String getAreaName() {
        return areaName;
    }


    public String getEnvironmentType() {
        return environmentType;
    }


    public String getDescription() {
        return description;
    }


}

