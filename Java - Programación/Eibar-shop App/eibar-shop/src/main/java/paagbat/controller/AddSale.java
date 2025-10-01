package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.DendarenAtzipena;

public class AddSale {

    @FXML
    ChoiceBox<String> choiceBoxUserId;
    @FXML
    ChoiceBox<String> choiceBoxProductId;

    @FXML
    Label userIdLabel;

    @FXML
    Label messageAdd;

    @FXML
    TextField userName;

    DendarenAtzipena dendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "sales", "ikaslea", "ikaslea");
    
    @FXML
    protected void initialize() {
        List<String> idUsers = dendarenAtzipena.getUsersId();
        List<String> idProducts = dendarenAtzipena.getProductsId();
        if (idUsers == null || idUsers.isEmpty()) {
            return;
        }
    
        for (String idU : idUsers) {
            choiceBoxUserId.getItems().add(idU);
        }

        for (String idP : idProducts) {
            choiceBoxProductId.getItems().add(idP);
        }
    }

    @FXML
    void handleUserId() {
        String username = userName.getText();
        String userID = dendarenAtzipena.getUserId(username);

        userIdLabel.setText("ID: " + userID);
    }

    @FXML
    void handleAdd() throws IOException{
        String uId = choiceBoxUserId.getValue();
        String pId = choiceBoxProductId.getValue();

        if (uId == null || uId.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty fields");
            alert.setContentText("The User Id or the Product Id is empty");
            alert.showAndWait();
        } else if (pId == null || pId.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty fields");
            alert.setContentText("The User Id or the Product Id is empty");
            alert.showAndWait();
        } else {
            int result = dendarenAtzipena.addSale(uId, pId);
            
            if (result == 1) {
                messageAdd.setText("The sale has been added");
                choiceBoxUserId.getSelectionModel().clearSelection();
                choiceBoxProductId.getSelectionModel().clearSelection();
                userIdLabel.setText("ID");
                userName.clear();
                App.setRoot("salesTable");
            } else if (result == -1) {
                messageAdd.setText("The product is already registered");
            } else {
                messageAdd.setText("There's been a problem");
            }
        }
    }
    
    @FXML
    void handleReturn() throws IOException {
        App.setRoot("salesTable");
    }
}
