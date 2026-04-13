package com.zomato.greening_india.service;

import com.zomato.greening_india.dto.LeaderboardDTO;
import com.zomato.greening_india.model.PlantationDrive;
import com.zomato.greening_india.model.PlantationRecord;
import com.zomato.greening_india.model.User;
import com.zomato.greening_india.repository.PlantationDriveRepository;
import com.zomato.greening_india.repository.PlantationRecordRepository;
import com.zomato.greening_india.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationRecordService {

    private final PlantationRecordRepository recordRepository;
    private final UserRepository userRepository;
    private final PlantationDriveRepository driveRepository;

    public PlantationRecordService(PlantationRecordRepository recordRepository,
                                   UserRepository userRepository,
                                   PlantationDriveRepository driveRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
        this.driveRepository = driveRepository;
    }

    public PlantationRecord saveRecord(PlantationRecord record) {

        User user = userRepository.findById(record.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PlantationDrive drive = driveRepository.findById(record.getDrive().getId())
                .orElseThrow(() -> new RuntimeException("Drive not found"));

        record.setUser(user);
        record.setDrive(drive);

        return recordRepository.save(record);
    }

    public List<PlantationRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<LeaderboardDTO> getLeaderboard() {
        List<Object[]> results = recordRepository.getLeaderboard();

        return results.stream()
                .map(r -> new LeaderboardDTO(
                        ((Number) r[0]).longValue(),
                        ((Number) r[1]).longValue()
                ))
                .toList();
    }
}