package com.zomato.greening_india.controller;

import com.zomato.greening_india.model.PlantationDrive;
import com.zomato.greening_india.service.PlantationDriveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drives")
public class PlantationDriveController {

    private final PlantationDriveService driveService;

    public PlantationDriveController(PlantationDriveService driveService) {
        this.driveService = driveService;
    }

    @PostMapping
    public PlantationDrive createDrive(@RequestBody PlantationDrive drive) {
        return driveService.createDrive(drive);
    }

    @GetMapping
    public List<PlantationDrive> getAllDrives() {
        return driveService.getAllDrives();
    }
}