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

    @PositiveOrZero(message = "Weight must be positive or zero")
    private float weight;

    @PositiveOrZero(message = "Length must be positive or zero")
    private float length;

    private LocalDateTime entryDate;

    @NotBlank(message = "Exhibit status is mandatory")
    @Size(max = 50, message = "Exhibit status cannot exceed 50 characters")
    private String exhibitStatus;

    @NotNull(message = "User ID is mandatory")
    private Integer userId;

    @NotNull(message = "Species ID is mandatory")
    private Integer speciesId;

    private List<MultipartFile> images;

    public AquaticCreaturesRequest(String name, float weight, float length, LocalDateTime entryDate, String exhibitStatus, Integer userId, Integer speciesId, List<MultipartFile> images) {
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.entryDate = entryDate;
        this.exhibitStatus = exhibitStatus;
        this.userId = userId;
        this.speciesId = speciesId;
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


    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public @NotNull(message = "Species ID is mandatory") Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(@NotNull(message = "Species ID is mandatory") Integer speciesId) {
        this.speciesId = speciesId;
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


    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}

