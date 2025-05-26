package com.example.camp.controller;

import com.example.camp.model.Camper;
import com.example.camp.model.Game;
import com.example.camp.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET all games
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getGames();
    }

    // GET game by ID
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.getGame(id);
    }


    // POST (create) a game
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    // PUT (update) a game
    @PutMapping("/{id}")
    public Game updateGame(@RequestBody Game game, @PathVariable Long id) {
        return gameService.updateGame(game, id);
    }

    // DELETE a game
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
