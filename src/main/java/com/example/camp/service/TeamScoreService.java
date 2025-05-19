package com.example.camp.service;

import com.example.camp.repository.TeamScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamScoreService {
    private final TeamScoreRepository teamScoreRepository;

    @Autowired
    public TeamScoreService(TeamScoreRepository teamScoreRepository) {
        this.teamScoreRepository = teamScoreRepository;
    }
}
