package com.example.camp.service;

import com.example.camp.model.Game;

import java.util.List;

public interface GameService {
    List<Game> getGames();
    Game getGame(Long id);
    Game createGame(Game game);
    Game updateGame(Game game, Long id);
    void deleteGame(Long id);
}
