package com.zomato.greening_india.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PlantationDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private LocalDate date;
    private int targetTrees;

    public PlantationDrive() {}

    public PlantationDrive(Long id, String location, LocalDate date, int targetTrees) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.targetTrees = targetTrees;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTargetTrees() {
        return targetTrees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTargetTrees(int targetTrees) {
        this.targetTrees = targetTrees;
    }
}
