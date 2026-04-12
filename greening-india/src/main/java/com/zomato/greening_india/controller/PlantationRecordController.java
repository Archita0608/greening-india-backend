package com.zomato.greening_india.controller;

import com.zomato.greening_india.dto.LeaderboardDTO;
import com.zomato.greening_india.model.PlantationRecord;
import com.zomato.greening_india.service.PlantationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class PlantationRecordController {

    private final PlantationRecordService recordService;

    public PlantationRecordController(PlantationRecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public PlantationRecord createRecord(@RequestBody PlantationRecord record) {
        return recordService.saveRecord(record);
    }

    @GetMapping
    public List<PlantationRecord> getAllRecords() {
        return recordService.getAllRecords();
    }

    @GetMapping("/leaderboard")
    public List<LeaderboardDTO> getLeaderboard() {
        return recordService.getLeaderboard();
    }
}
