package com.example.camp.controller;

import com.example.camp.model.Team;
import com.example.camp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams") // Base route for teams
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // GET /api/teams
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getTeams();
    }

    // GET /api/teams/{id}
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    // POST /api/teams
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    // PUT /api/teams/{id}
    @PutMapping("/{id}")
    public Team updateTeam(@RequestBody Team team, @PathVariable Long id) {
        return teamService.updateTeam(team, id);
    }

    // DELETE /api/teams/{id}
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}