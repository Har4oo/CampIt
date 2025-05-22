package com.example.camp.service.implementation;

import com.example.camp.model.Game;
import com.example.camp.repository.GameRepository;
import com.example.camp.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImplementation implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImplementation(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game, Long id) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
        System.out.println("Updating game with id: "+ existingGame.getId());

        existingGame.setName(game.getName());
        existingGame.setDescription(game.getDescription());
        existingGame.setTeamScores(game.getTeamScores());
        return gameRepository.save(existingGame);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
