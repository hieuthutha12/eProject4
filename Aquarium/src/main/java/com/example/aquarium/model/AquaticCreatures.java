package com.example.aquarium.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "aquatic_creatures")
public class AquaticCreatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;  // Tham chiếu đến loài

    @Column(name = "weight")
    private Float weight;

    @Column(name = "length")
    private Float length;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "exhibit_status")
    private String exhibitStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Tham chiếu đến người dùng

    @OneToMany(mappedBy = "aquaticCreatures", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Img> images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public List<Img> getImages() {
        return images;
    }

    public void setImages(List<Img> images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }


    public String getExhibitStatus() {
        return exhibitStatus;
    }

    public void setExhibitStatus(String exhibitStatus) {
        this.exhibitStatus = exhibitStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
