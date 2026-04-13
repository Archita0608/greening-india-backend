package com.zomato.greening_india.controller;

import com.zomato.greening_india.dto.LeaderboardDTO;
import com.zomato.greening_india.model.PlantationRecord;
import com.zomato.greening_india.service.PlantationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantation-records")
public class PlantationRecordController {

    private final PlantationRecordService service;

    public PlantationRecordController(PlantationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public PlantationRecord create(@RequestBody PlantationRecord record) {
        return service.saveRecord(record);
    }

    @GetMapping
    public List<PlantationRecord> getAll() {
        return service.getAllRecords();
    }

    @GetMapping("/leaderboard")
    public List<LeaderboardDTO> leaderboard() {
        return service.getLeaderboard();
    }
}