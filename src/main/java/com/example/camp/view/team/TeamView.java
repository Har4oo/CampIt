package com.example.camp.view.team;

import com.example.camp.model.Team;
import com.example.camp.service.TeamService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamView extends VerticalLayout {
    private final TeamService teamService;
    private final Grid<Team> grid = new Grid<>(Team.class);

    public TeamView(TeamService teamService) {
        this.teamService = teamService;

        grid.setColumns("name", "teamColour", "teamPoints");
        grid.setItems(teamService.getTeams());

        //grid.addComponentColumn(this::createActionButtons).setHeader("Actions");

        Button addTeamButton = new Button("Add Team", buttonClickEvent -> openTeamDialog());

        orderCards();

        add(addTeamButton,grid);
    }
    //TODO: Implement edit dialog
//    private HorizontalLayout createActionButtons(Camper camper) {
//        Button editButton = new Button("Edit", e -> openEditCamperDialog(camper));
//        Button deleteButton = new Button("Delete", e -> {
//            camperService.deleteCamper(camper.getId());
//            grid.setItems(camperService.getCampers()); // Refresh grid
//        });
//
//        return new HorizontalLayout(editButton, deleteButton);
//    }

    //TODO: Dialog which creates a new team. Fields:
    private void openTeamDialog() {
        Dialog dialog = new Dialog();

        TextField nameField = new TextField("Team name");
        TextField colourField = new TextField("Team colour");
        NumberField pointsField = new NumberField("Team points");

        Button saveButton = new Button("Save", buttonClickEvent -> {
            Team team = new Team();
            team.setName(nameField.getValue());
            team.setTeamColour(colourField.getValue());
            team.setTeamPoints(pointsField.getValue());
        });
        Button cancelButton = new Button("Cancel", e -> dialog.close());

        dialog.add(new VerticalLayout(nameField,colourField,pointsField), new HorizontalLayout(saveButton,cancelButton));

        dialog.open();

    }
    private void orderCards(){
        Card card = new Card();

        card.add(new H1("Test"));

        add(card);
    }
}
