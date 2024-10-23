package com.example.aquarium.bean.response;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AquaticCreaturesResponse {

    private int id;
    private String name;
    private String habitat;
    private String diet;
    private float weight;
    private float length;
    private int averageLifespan;
    private String specialCharacteristics;
    private LocalDateTime entryDate;
    private String exhibitStatus;
    private String species;
    private String user;
    private List<String> imgName;


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public AquaticCreaturesResponse() {
    }



    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public float getWeight() {
        return weight;
    }

    public float getLength() {
        return length;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }

    public String getSpecialCharacteristics() {
        return specialCharacteristics;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public String getExhibitStatus() {
        return exhibitStatus;
    }

    public List<String> getImgName() {
        return imgName;
    }



    public void setId(int id) {
        this.id = id;
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


    public void setWeight(float weight) {
        this.weight = weight;
    }


    public void setLength(float length) {
        this.length = length;
    }


    public void setAverageLifespan(int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }


    public void setSpecialCharacteristics(String specialCharacteristics) {
        this.specialCharacteristics = specialCharacteristics;
    }


    public void setExhibitStatus(String exhibitStatus) {
        this.exhibitStatus = exhibitStatus;
    }




    public void setImgName(List<String> imgName) {
        this.imgName = imgName;
    }
}

