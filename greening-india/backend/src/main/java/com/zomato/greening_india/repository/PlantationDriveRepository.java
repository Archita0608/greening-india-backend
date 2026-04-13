package com.zomato.greening_india.repository;

import com.zomato.greening_india.model.PlantationDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantationDriveRepository extends JpaRepository<PlantationDrive, Long> {
}