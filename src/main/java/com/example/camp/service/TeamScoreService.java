package com.example.camp.service;

import com.example.camp.model.TeamScore;

import java.util.List;

public interface TeamScoreService {
    List<TeamScore> getTeamScores();
    TeamScore getTeamscore(Long id);
    TeamScore createTeamScore(TeamScore teamScore);
    TeamScore updateTeamScore(TeamScore teamScore, Long id);
    void deleteTeamScore(Long id);
}
