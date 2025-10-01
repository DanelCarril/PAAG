package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.User;



public class DeleteUsers {
    @FXML
    VBox vBoxdelete;

    private List<CheckBox> checkBoxList = new java.util.ArrayList<>();

    @FXML
    protected void initialize() {
        DendarenAtzipena herrienAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "users", "Don omar","friopolar");
        List<User> users = herrienAtzipena.getAllUsers();

        checkBoxList.clear();
        // Checkboxak sortzen ditu
        for (User user : users) {
            String username = user.getUsername();
            CheckBox checkBox = new CheckBox(username);
            vBoxdelete.getChildren().add(checkBox);
            checkBoxList.add(checkBox);
        }
    }
    @FXML
    void handleReturn() throws IOException {
        App.setRoot("editusers");
    }

    @FXML
    void handleEzabatu() throws IOException {
        // Ezabatu metodoari deitzen diogu checkboxan aukeratuta dagoena ezabatzeko
        DendarenAtzipena herrienAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "users", "Don omar","friopolar");
        for (CheckBox checkBox : checkBoxList)
            if (checkBox.isSelected())
                herrienAtzipena.deleteUser(checkBox.getText());   
        App.setRoot("editusers");
    }
    
}
