package com.example.aquarium.bean.response;

import java.util.List;

public class AreaResponse {

    private String areaName;

    private String environmentType;

    private String description;

    private List<String> aquaticCreaturesName;

    public AreaResponse() {
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
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

    public List<String> getAquaticCreaturesName() {
        return aquaticCreaturesName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAquaticCreaturesName(List<String> aquaticCreaturesName) {
        this.aquaticCreaturesName = aquaticCreaturesName;
    }
}

