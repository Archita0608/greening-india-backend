package com.zomato.greening_india.service;

import com.zomato.greening_india.model.PlantationDrive;
import com.zomato.greening_india.repository.PlantationDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationDriveService {

    private final PlantationDriveRepository driveRepository;

    public PlantationDriveService(PlantationDriveRepository driveRepository) {
        this.driveRepository = driveRepository;
    }

    public PlantationDrive createDrive(PlantationDrive drive) {
        return driveRepository.save(drive);
    }

    public List<PlantationDrive> getAllDrives() {
        return driveRepository.findAll();
    }
}
