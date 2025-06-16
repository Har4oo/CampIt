package com.example.camp.view.camper;

import com.example.camp.model.Team;
import com.example.camp.service.TeamService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamView extends VerticalLayout {
    private final TeamService teamService;
    private final Grid<Team> grid = new Grid<>(Team.class);

    @Autowired
    public TeamView(TeamService teamService) {
        this.teamService = teamService;

        grid.setColumns("name", "teamColour", "teamPoints");
        grid.setItems(teamService.getTeams());

        add(grid);
    }

    //TODO: Dialog which creates a new team. Fields:
    private void openTeamDialog() {

    }
}
