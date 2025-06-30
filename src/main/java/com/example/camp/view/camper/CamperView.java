package com.example.camp.view.camper;

import com.example.camp.model.Camper;
import com.example.camp.service.CamperService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

public class CamperView extends VerticalLayout {
    private final CamperService camperService;
    private final Grid<Camper> grid = new Grid<>(Camper.class);



    public CamperView(CamperService camperService) {
        this.camperService = camperService;

        grid.setColumns("firstName", "lastName", "birthDate", "male", "role");
        grid.setItems(camperService.getCampers());

        grid.addComponentColumn(this::createActionButtons)
                .setHeader("Actions");

        Button addCamperButton = new Button("Add Camper", e -> openCamperDialog());

        add(addCamperButton, grid);
    }

    private HorizontalLayout createActionButtons(Camper camper) {
        Button editButton = new Button("Edit", e -> openEditCamperDialog(camper));
        Button deleteButton = new Button("Delete", e -> {
            camperService.deleteCamper(camper.getId());
            grid.setItems(camperService.getCampers()); // Refresh grid
        });

        return new HorizontalLayout(editButton, deleteButton);
    }

    private void openEditCamperDialog(Camper camperToEdit) {
        Dialog dialog = new Dialog();

        TextField firstNameField = new TextField("First Name");
        TextField lastNameField = new TextField("Last Name");
        DatePicker birthDatePicker = new DatePicker("Birth Date");
        Checkbox maleCheckbox = new Checkbox("Male");
        ComboBox<String> roleBox = new ComboBox<>("Role");
        roleBox.addCustomValueSetListener(event -> {
            roleBox.setValue(event.getDetail()); //Allowing to create custom values instead of having only camper and leader - https://vaadin.com/forum/t/combobox-with-custom-values-allowed-fails-validation/163235/5
        });
        roleBox.setItems("camper", "leader");

        if (camperToEdit != null) {
            firstNameField.setValue(camperToEdit.getFirstName());
            lastNameField.setValue(camperToEdit.getLastName());
            birthDatePicker.setValue(camperToEdit.getBirthDate());
            roleBox.setValue(camperToEdit.getRole());
        }

        Button saveButton = new Button("Save", event -> {
            Camper camper = camperToEdit != null ? camperToEdit : new Camper();

            camper.setFirstName(firstNameField.getValue());
            camper.setLastName(lastNameField.getValue());
            camper.setBirthDate(birthDatePicker.getValue());
            camper.setMale(maleCheckbox.getValue());
            camper.setRole(roleBox.getValue());

            if (camperToEdit != null) {
                camperService.updateCamper(camper,camper.getId()); // Assumes update logic
            } else {
                camperService.createCamper(camper);
            }

            grid.setItems(camperService.getCampers());
            dialog.close();
        });

        Button cancelButton = new Button("Cancel", e -> dialog.close());

        dialog.add(new VerticalLayout(
                firstNameField, lastNameField,
                birthDatePicker, maleCheckbox,
                roleBox,
                new HorizontalLayout(saveButton, cancelButton)
        ));

        dialog.open();
    }


    private void openCamperDialog() {
        Dialog dialog = new Dialog();

        TextField firstNameField = new TextField("First Name");
        TextField lastNameField = new TextField("Last Name");
        DatePicker birthDatePicker = new DatePicker("Birth Date");
        Checkbox maleCheckbox = new Checkbox("Male");
        ComboBox<String> roleBox = new ComboBox<>("Role");
        roleBox.addCustomValueSetListener(event -> {
            roleBox.setValue(event.getDetail());
        });
        roleBox.setItems("camper", "leader");

        Button saveButton = new Button("Save", event -> {
            Camper camper = new Camper();
            camper.setFirstName(firstNameField.getValue());
            camper.setLastName(lastNameField.getValue());
            camper.setBirthDate(birthDatePicker.getValue());
            camper.setMale(maleCheckbox.getValue());
            camper.setRole(roleBox.getValue());

            camperService.createCamper(camper); // Save to DB
            grid.setItems(camperService.getCampers()); // Refresh list
            dialog.close();
        });

        Button cancelButton = new Button("Cancel", e -> dialog.close());

        dialog.add(new VerticalLayout(
                firstNameField, lastNameField,
                birthDatePicker, maleCheckbox,
                roleBox,
                new HorizontalLayout(saveButton, cancelButton)
        ));

        dialog.open();
    }
}
