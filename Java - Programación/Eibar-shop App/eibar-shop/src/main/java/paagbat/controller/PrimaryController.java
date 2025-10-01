package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.DendarenAtzipena;

public class PrimaryController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private static String loggedInUser = "";

    DendarenAtzipena dendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "sales", "ikaslea", "ikaslea");

    @FXML
    void handleLoginButtonClick() throws IOException { 
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validar el usuario utilizando el método validateUser
        List<String> userData = dendarenAtzipena.validateUser(username, password);

        if (userData != null && !userData.isEmpty()) {
            loggedInUser = username;
            App.setRoot("chooseTable");
        } else {
            // Si las credenciales no son válidas
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Log-in");
            alert.setHeaderText("Incorrect log in");
            alert.setContentText("The username or the password is incorrect");
            alert.showAndWait();
        }
    }

    @FXML
    void handleCancelButtonClick() {
        Platform.exit();
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
}
