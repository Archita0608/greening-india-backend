package com.zomato.greening_india.service;

import com.zomato.greening_india.dto.LeaderboardDTO;
import com.zomato.greening_india.model.PlantationRecord;
import com.zomato.greening_india.repository.PlantationRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationRecordService {

    private final PlantationRecordRepository recordRepository;

    public PlantationRecordService(PlantationRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public PlantationRecord saveRecord(PlantationRecord record) {
        return recordRepository.save(record);
    }

    public List<PlantationRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<LeaderboardDTO> getLeaderboard() {
        List<Object[]> results = recordRepository.getLeaderboard();

        return results.stream()
                .map(r -> new LeaderboardDTO(
                        (Long) r[0],
                        (Long) r[1]
                ))
                .toList();
    }
}