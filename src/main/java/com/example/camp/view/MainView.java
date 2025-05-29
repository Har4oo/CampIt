package com.example.camp.view;

import com.example.camp.model.Camper;
import com.example.camp.service.CamperService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("home")
public class MainView extends VerticalLayout {
    private final CamperService camperService;
    private final Grid<Camper> grid = new Grid<>(Camper.class);

    @Autowired
    public MainView(CamperService camperService) {
        this.camperService = camperService;

        configureGrid();
        add(grid);

        updateGrid();
    }

    private void configureGrid() {
        grid.setColumns("firstName", "lastName", "birthDate", "role", "male");
        grid.getColumnByKey("birthDate").setHeader("Birth Date");
        grid.getColumnByKey("firstName").setHeader("First Name");
        grid.getColumnByKey("lastName").setHeader("Last Name");
        grid.getColumnByKey("male").setHeader("Is Male");
    }

    private void updateGrid() {
        grid.setItems(camperService.getCampers());
    }
}
