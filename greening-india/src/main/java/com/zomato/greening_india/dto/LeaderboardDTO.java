package com.zomato.greening_india.dto;

public class LeaderboardDTO {

    private Long userId;
    private Long totalTrees;

    public LeaderboardDTO(Long userId, Long totalTrees) {
        this.userId = userId;
        this.totalTrees = totalTrees;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTotalTrees() {
        return totalTrees;
    }
}
