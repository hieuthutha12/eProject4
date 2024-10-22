package com.example.aquarium.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Aquatic_Creatures")
public class AquaticCreatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "species", length = 50)
    private String species;

    @Column(name = "habitat", length = 50)
    private String habitat;

    @Column(name = "diet", length = 100)
    private String diet;

    @Column(name = "weight")
    private float weight;

    @Column(name = "length")
    private float length;

    @Column(name = "averageLifespan")
    private int averageLifespan;

    @Column(name = "specialCharacteristics", length = 255)
    private String specialCharacteristics;

    @Column(name = "entryDate")
    private LocalDateTime entryDate;

    @Column(name = "exhibitStatus", length = 50)
    private String exhibitStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "aquaticCreatures", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Img> images;

    public AquaticCreatures() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public List<Img> getImages() {
        return images;
    }

    public void setImages(List<Img> images) {
        this.images = images;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getSpecialCharacteristics() {
        return specialCharacteristics;
    }

    public void setSpecialCharacteristics(String specialCharacteristics) {
        this.specialCharacteristics = specialCharacteristics;
    }

    public String getExhibitStatus() {
        return exhibitStatus;
    }

    public void setExhibitStatus(String exhibitStatus) {
        this.exhibitStatus = exhibitStatus;
    }


    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

