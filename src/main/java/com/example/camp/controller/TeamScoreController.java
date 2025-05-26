package com.example.camp.controller;

import com.example.camp.model.TeamScore;
import com.example.camp.service.TeamScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-scores") // Base route
public class TeamScoreController {

    private final TeamScoreService teamScoreService;

    @Autowired
    public TeamScoreController(TeamScoreService teamScoreService) {
        this.teamScoreService = teamScoreService;
    }

    // GET /api/team-scores
    @GetMapping
    public List<TeamScore> getAllTeamScores() {
        return teamScoreService.getTeamScores();
    }

    // GET /api/team-scores/{id}
    @GetMapping("/{id}")
    public TeamScore getTeamScoreById(@PathVariable Long id) {
        return teamScoreService.getTeamscore(id);
    }

    // POST /api/team-scores
    @PostMapping
    public TeamScore createTeamScore(@RequestBody TeamScore teamScore) {
        return teamScoreService.createTeamScore(teamScore);
    }

    // PUT /api/team-scores/{id}
    @PutMapping("/{id}")
    public TeamScore updateTeamScore(@RequestBody TeamScore teamScore, @PathVariable Long id) {
        return teamScoreService.updateTeamScore(teamScore, id);
    }

    // DELETE /api/team-scores/{id}
    @DeleteMapping("/{id}")
    public void deleteTeamScore(@PathVariable Long id) {
        teamScoreService.deleteTeamScore(id);
    }
}
