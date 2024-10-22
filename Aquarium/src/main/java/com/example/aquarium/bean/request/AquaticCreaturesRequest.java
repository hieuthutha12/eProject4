package com.example.aquarium.bean.request;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AquaticCreaturesRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Size(max = 50, message = "Species cannot exceed 50 characters")
    private String species;

    @Size(max = 50, message = "Habitat cannot exceed 50 characters")
    private String habitat;

    @Size(max = 100, message = "Diet cannot exceed 100 characters")
    private String diet;

    @PositiveOrZero(message = "Weight must be positive or zero")
    private float weight;

    @PositiveOrZero(message = "Length must be positive or zero")
    private float length;

    @Min(value = 1, message = "Lifespan must be at least 1 year")
    private int averageLifespan;

    @Size(max = 255, message = "Special characteristics cannot exceed 255 characters")
    private String specialCharacteristics;

    private LocalDateTime entryDate;

    @NotBlank(message = "Exhibit status is mandatory")
    @Size(max = 50, message = "Exhibit status cannot exceed 50 characters")
    private String exhibitStatus;

    @NotNull(message = "User ID is mandatory")
    private Integer userId;

    @NotNull(message = "Area ID is mandatory")
    private Integer areaId;

    private List<MultipartFile> images;

    public AquaticCreaturesRequest(String name, String species, String habitat, String diet, float weight, float length, int averageLifespan, String specialCharacteristics, LocalDateTime entryDate, String exhibitStatus, Integer userId, Integer areaId, List<MultipartFile> images) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
        this.weight = weight;
        this.length = length;
        this.averageLifespan = averageLifespan;
        this.specialCharacteristics = specialCharacteristics;
        this.entryDate = entryDate;
        this.exhibitStatus = exhibitStatus;
        this.userId = userId;
        this.areaId = areaId;
        this.images = images;
    }

    public AquaticCreaturesRequest() {
    }

    public @NotBlank(message = "Name is mandatory") @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @Size(max = 50, message = "Species cannot exceed 50 characters") String getSpecies() {
        return species;
    }

    public void setSpecies(@Size(max = 50, message = "Species cannot exceed 50 characters") String species) {
        this.species = species;
    }

    public @Size(max = 50, message = "Habitat cannot exceed 50 characters") String getHabitat() {
        return habitat;
    }

    public void setHabitat(@Size(max = 50, message = "Habitat cannot exceed 50 characters") String habitat) {
        this.habitat = habitat;
    }

    public @Size(max = 100, message = "Diet cannot exceed 100 characters") String getDiet() {
        return diet;
    }

    public void setDiet(@Size(max = 100, message = "Diet cannot exceed 100 characters") String diet) {
        this.diet = diet;
    }

    @PositiveOrZero(message = "Weight must be positive or zero")
    public float getWeight() {
        return weight;
    }

    public void setWeight(@PositiveOrZero(message = "Weight must be positive or zero") float weight) {
        this.weight = weight;
    }

    @PositiveOrZero(message = "Length must be positive or zero")
    public float getLength() {
        return length;
    }

    public void setLength(@PositiveOrZero(message = "Length must be positive or zero") float length) {
        this.length = length;
    }

    @Min(value = 1, message = "Lifespan must be at least 1 year")
    public int getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(@Min(value = 1, message = "Lifespan must be at least 1 year") int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public @Size(max = 255, message = "Special characteristics cannot exceed 255 characters") String getSpecialCharacteristics() {
        return specialCharacteristics;
    }

    public void setSpecialCharacteristics(@Size(max = 255, message = "Special characteristics cannot exceed 255 characters") String specialCharacteristics) {
        this.specialCharacteristics = specialCharacteristics;
    }


    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public @NotBlank(message = "Exhibit status is mandatory") @Size(max = 50, message = "Exhibit status cannot exceed 50 characters") String getExhibitStatus() {
        return exhibitStatus;
    }

    public void setExhibitStatus(@NotBlank(message = "Exhibit status is mandatory") @Size(max = 50, message = "Exhibit status cannot exceed 50 characters") String exhibitStatus) {
        this.exhibitStatus = exhibitStatus;
    }

    public @NotNull(message = "User ID is mandatory") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID is mandatory") Integer userId) {
        this.userId = userId;
    }

    public @NotNull(message = "Area ID is mandatory") Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(@NotNull(message = "Area ID is mandatory") Integer areaId) {
        this.areaId = areaId;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}

