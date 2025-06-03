package com.example.camp.view;

import com.example.camp.model.Camper;
import com.example.camp.service.CamperService;
import com.example.camp.view.camper.CamperView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("home")
public class MainView extends AppLayout {
    public MainView() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("TEXT");
        //THE HARDEST THING EVER-CENTERING A DIV :O (in that case an h1)
        logo.getStyle()
                .set("margin", "1rem")
                .set("width", "100%")
                .set("display", "flex")
                .set("justify-content", "center")
                .set("align-items", "center");;

        addToNavbar(logo);
    }

    private void createDrawer() {
        RouterLink campersLink = new RouterLink("Campers", CamperView.class);

        VerticalLayout navLayout = new VerticalLayout(campersLink);
        navLayout.setPadding(true);
        navLayout.setSpacing(true);

        addToDrawer(navLayout);
    }
}
