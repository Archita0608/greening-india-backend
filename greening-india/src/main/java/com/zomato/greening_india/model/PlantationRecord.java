package com.zomato.greening_india.model;

import jakarta.persistence.*;

@Entity
public class PlantationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private PlantationDrive drive;

    private int treesPlanted;

    public PlantationRecord() {}

    public PlantationRecord(Long id, User user, PlantationDrive drive, int treesPlanted) {
        this.id = id;
        this.user = user;
        this.drive = drive;
        this.treesPlanted = treesPlanted;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public PlantationDrive getDrive() {
        return drive;
    }

    public int getTreesPlanted() {
        return treesPlanted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDrive(PlantationDrive drive) {
        this.drive = drive;
    }

    public void setTreesPlanted(int treesPlanted) {
        this.treesPlanted = treesPlanted;
    }
}