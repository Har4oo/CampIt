package com.example.camp.service.implementation;

import com.example.camp.model.Team;
import com.example.camp.repository.CamperRepository;
import com.example.camp.repository.TeamRepository;
import com.example.camp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImplementation implements TeamService {
    private final TeamRepository teamRepository;


    @Autowired
    public TeamServiceImplementation(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
    }

    @Override
    public Team createTeam(Team team) {
        System.out.println("Creating team: "+ team.getName());
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team, Long id) {
        Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
        System.out.println("Updating team with id: " + existingTeam.getId());

        existingTeam.setName(team.getName());
        existingTeam.setTeamColour(team.getTeamColour());
        existingTeam.setTeamPoints(team.getTeamPoints());
        existingTeam.setTeamScores(team.getTeamScores());

        return teamRepository.save(existingTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
