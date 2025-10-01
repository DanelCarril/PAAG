package paagbat.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.User;

public class EditUsers {

    @FXML private TableView<User> tableViewUsers;
    @FXML private TableColumn<User, String> tableColumnUsername;
    @FXML private TableColumn<User, String> tableColumnPassword;
    @FXML private TableColumn<User, String> tableColumnEmail;

    @FXML private Button updateButton;
    @FXML private Button exitButton;
    @FXML private Button returnButton;

    private DendarenAtzipena uAtzipena;

    public EditUsers() {
        uAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "users", "Don omar", "friopolar");
    }

    @FXML
    public void initialize() {
        
        ObservableList<User> userList = FXCollections.observableArrayList(uAtzipena.getAllUsers());

        
        tableViewUsers.setItems(userList);

        tableColumnUsername.prefWidthProperty().bind(tableViewUsers.widthProperty().multiply(0.30));
        tableColumnPassword.prefWidthProperty().bind(tableViewUsers.widthProperty().multiply(0.30));
        tableColumnEmail.prefWidthProperty().bind(tableViewUsers.widthProperty().multiply(0.39));

        // Taularen tamaina konfiguratu
        tableColumnUsername.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        tableColumnPassword.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        tableColumnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        // Kolumnak editatzeko kodea
        tableViewUsers.setEditable(true);
        tableColumnUsername.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
        tableColumnPassword.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
        tableColumnEmail.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));

        // Taula editatzerakoan datuak gorde
        tableColumnUsername.setOnEditCommit(event -> {
            User user = event.getRowValue();
            user.setUsername(event.getNewValue());
            uAtzipena.updateUser(user);
        });

        tableColumnPassword.setOnEditCommit(event -> {
            User user = event.getRowValue();
            user.setPassword(event.getNewValue());
            uAtzipena.updateUser(user);
        });

        tableColumnEmail.setOnEditCommit(event -> {
            User user = event.getRowValue();
            user.setEmail(event.getNewValue());
            uAtzipena.updateUser(user);
        });
    }

    @FXML
    void handleReturn() throws IOException {
        App.setRoot("chooseTable");
    }

    @FXML
    void handleDeleteScene() throws IOException {
        App.setRoot("deleteusers");
    }

    @FXML
    void handleAddScene() throws IOException {
        App.setRoot("addusers");
    }
}
