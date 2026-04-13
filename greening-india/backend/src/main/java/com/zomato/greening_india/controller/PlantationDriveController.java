package com.zomato.greening_india.controller;

import com.zomato.greening_india.model.PlantationDrive;
import com.zomato.greening_india.repository.PlantationDriveRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantation-drives")
public class PlantationDriveController {

    private final PlantationDriveRepository repository;

    public PlantationDriveController(PlantationDriveRepository repository) {
        this.repository = repository;
    }

    // CREATE drive
    @PostMapping
    public PlantationDrive create(@RequestBody PlantationDrive drive) {
        return repository.save(drive);
    }

    // GET all drives
    @GetMapping
    public List<PlantationDrive> getAll() {
        return repository.findAll();
    }
}