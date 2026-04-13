package com.zomato.greening_india.repository;

import com.zomato.greening_india.model.PlantationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantationRecordRepository extends JpaRepository<PlantationRecord, Long> {

    @Query("""
        SELECT r.user.id, SUM(r.treesPlanted)
        FROM PlantationRecord r
        WHERE r.user IS NOT NULL
        GROUP BY r.user.id
        ORDER BY SUM(r.treesPlanted) DESC
    """)
    List<Object[]> getLeaderboard();
}