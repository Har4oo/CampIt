package com.example.camp.service.implementation;

import com.example.camp.model.TeamScore;
import com.example.camp.repository.TeamScoreRepository;
import com.example.camp.service.TeamScoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamScoreServiceImplementation implements TeamScoreService {
    private final TeamScoreRepository teamScoreRepository;

    @Autowired
    public TeamScoreServiceImplementation(TeamScoreRepository teamScoreRepository) {
        this.teamScoreRepository = teamScoreRepository;
    }

    @Override
    public List<TeamScore> getTeamScores() {
        return teamScoreRepository.findAll();
    }

    @Override
    public TeamScore getTeamscore(Long id) {
        System.out.println("Listing teamscore with id: "+id);
        return teamScoreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public TeamScore createTeamScore(TeamScore teamScore) {
        System.out.println("Creating TeamScore: " + teamScore.getPoints());
        return teamScoreRepository.save(teamScore);
    }

    @Override
    public TeamScore updateTeamScore(TeamScore teamScore, Long id) {
        TeamScore existingTeamScore = teamScoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TeamScore not found with id: " + id));

        System.out.println("Updating teamScore with id: "+existingTeamScore.getId());

        existingTeamScore.setPoints(teamScore.getPoints());
        existingTeamScore.setGame(teamScore.getGame());
        existingTeamScore.setTeam(teamScore.getTeam());

        return teamScoreRepository.save(existingTeamScore);
    }

    @Override
    public void deleteTeamScore(Long id) {
        teamScoreRepository.deleteById(id);
    }
}
