package com.example.camp.service.implementation;

import com.example.camp.repository.TeamScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamScoreServiceImplementation {
    private final TeamScoreRepository teamScoreRepository;

    @Autowired
    public TeamScoreServiceImplementation(TeamScoreRepository teamScoreRepository) {
        this.teamScoreRepository = teamScoreRepository;
    }
}
