package com.example.aquarium.bean.response;

import java.util.List;

public class SpeciesResponse {

    private String name;
    private String habitat;
    private String diet;
    private Integer averageLifespan;
    private String specialCharacteristics;
    private List<String> aquaticCreaturesName;

    public SpeciesResponse() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setAverageLifespan(Integer averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public void setSpecialCharacteristics(String specialCharacteristics) {
        this.specialCharacteristics = specialCharacteristics;
    }

    public void setAquaticCreaturesName(List<String> aquaticCreaturesName) {
        this.aquaticCreaturesName = aquaticCreaturesName;
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public Integer getAverageLifespan() {
        return averageLifespan;
    }

    public String getSpecialCharacteristics() {
        return specialCharacteristics;
    }

    public List<String> getAquaticCreaturesName() {
        return aquaticCreaturesName;
    }
}
