package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.User;

public class AddUsers {

    @FXML
    TextField username;

    @FXML
    TextField firstname;

    @FXML
    TextField lastname;

    @FXML
    TextField email;

    @FXML
    TextField password;
    @FXML
    private ChoiceBox<String> enumrole;

    DendarenAtzipena uAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "users", "Don omar","friopolar");

    @FXML
    public void initialize() {
        List<String> roles = uAtzipena.getEnumRolesFromDB();
        enumrole.getItems().addAll(roles);
        enumrole.getSelectionModel().selectFirst(); 
    }

    public void adduser() throws IOException {
        String Username = username.getText().trim();
        String Firstname = firstname.getText().trim();
        String Lastname = lastname.getText().trim();
        String Email = email.getText().trim();
        String Password = password.getText().trim();
    
        // ChoiceBoxaren balorea hartzen du
        String selectedRole = enumrole.getValue();
    
        // Konprobatu ea choiceboxa null-a den edo ez
        if (Username.isEmpty() || Firstname.isEmpty() || Lastname.isEmpty() || Email.isEmpty() || Password.isEmpty() || selectedRole == null || selectedRole.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty fields");
            alert.setContentText("It looks like there is an empty field");
            alert.showAndWait();
        } else {
            User.Role role = User.Role.valueOf(selectedRole.toUpperCase());
            User user = new User(Username, Firstname, Lastname, Email, Password, role);
    
            uAtzipena.insertUser(user);
            App.setRoot("editusers");
        }
    }
    
    
    
    

    @FXML
    void handleReturn() throws IOException {
        App.setRoot("editusers");
    }
}
