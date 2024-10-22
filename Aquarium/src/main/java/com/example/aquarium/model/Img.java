package com.example.aquarium.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Img {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aquaticCreatures_id", nullable = false)
    private AquaticCreatures aquaticCreatures;

    private String imgName;


    private String description;

    public Img(Integer id, AquaticCreatures aquaticCreatures, String imgName, String description) {
        this.id = id;
        this.aquaticCreatures = aquaticCreatures;
        this.imgName = imgName;
        this.description = description;
    }

    public Img() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AquaticCreatures getAquaticCreatures() {
        return aquaticCreatures;
    }

    public void setAquaticCreatures(AquaticCreatures aquaticCreatures) {
        this.aquaticCreatures = aquaticCreatures;
    }

    public @NotBlank(message = "Image name is required") String getImgName() {
        return imgName;
    }

    public void setImgName(@NotBlank(message = "Image name is required") String imgName) {
        this.imgName = imgName;
    }

    public @Size(max = 500, message = "Description can be at most 500 characters") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500, message = "Description can be at most 500 characters") String description) {
        this.description = description;
    }
}

