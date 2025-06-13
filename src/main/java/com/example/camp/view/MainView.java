package com.example.camp.view;

import com.example.camp.model.Camper;
import com.example.camp.service.CamperService;
import com.example.camp.view.camper.CamperView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

@Route("home")
public class MainView extends AppLayout {
    private final VerticalLayout contentArea = new VerticalLayout();
    private final CamperService camperService;

    @Autowired
    public MainView(CamperService camperService) {
        this.camperService = camperService;
        createHeader();
        createDrawer();
        setContent(contentArea); // Display area
    }

    private void createHeader() {
        H1 title = new H1("CampIt");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        DrawerToggle toggle = new DrawerToggle();
        HorizontalLayout header = new HorizontalLayout(toggle, title);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        Button campersButton = new Button("Campers", e -> showCampers());

        VerticalLayout navLayout = new VerticalLayout(campersButton);
        navLayout.setPadding(true);
        navLayout.setSpacing(true);

        Scroller scroller = new Scroller(navLayout);
        addToDrawer(scroller);
        setPrimarySection(Section.DRAWER);
    }

    private void showCampers() {
        contentArea.removeAll();
        contentArea.add(new CamperView(camperService)); // You must change CamperView to not use @Route
    }

//    private void showTeams() {
//        contentArea.removeAll();
//        contentArea.add(new TeamView()); // Same here
//    }
//
//    private void showGames() {
//        contentArea.removeAll();
//        contentArea.add(new GameView()); // Same here
//    }
}
