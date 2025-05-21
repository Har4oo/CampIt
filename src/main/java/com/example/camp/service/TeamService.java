package com.example.camp.service;

import com.example.camp.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getTeams();
    Team getTeam(Long id);
    Team createTeam(Team team);
    Team updateTeam(Team team, Long id);
    void deleteTeam(Long id);
}
