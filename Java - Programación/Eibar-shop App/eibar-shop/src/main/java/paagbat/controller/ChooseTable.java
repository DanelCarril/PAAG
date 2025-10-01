package paagbat.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import paagbat.App;

public class ChooseTable {

    @FXML
    Label adminName;

    @FXML
    protected void initialize() {
        String loggedInUser = PrimaryController.getLoggedInUser();

        adminName.setText("Admin: " + loggedInUser);
    }

    @FXML
    void handleReturn() throws IOException {
        App.setRoot("logIn");
    }

    @FXML
    void handleUsers() throws IOException {
        App.setRoot("editusers");
    }

    @FXML
    void handleProduct() throws IOException {
        App.setRoot("productstable");
    }

    @FXML
    void handleSales() throws IOException {
        App.setRoot("salesTable");
    }
}
