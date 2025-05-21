package com.example.camp.service.implementation;

import com.example.camp.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImplementation {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImplementation(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
}
