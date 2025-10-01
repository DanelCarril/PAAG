package paagbat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;  // Para generar IDs únicos para los productos

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.ProductsBase;

public class AddProducts {

    public DendarenAtzipena ProductDendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database",
            "product", "Don Omar", "FrioPolar");
    List<String> productList = new ArrayList<>();
    
    @FXML
    private TextField userName;

    @FXML
    private Label userIdLabel;

    @FXML
    private ChoiceBox<String> UserId;

    @FXML
    private ChoiceBox<String> choiceBoxCategories;
    
    @FXML
    private TextField ProductName;
    
    @FXML
    private TextField ProductPrice;
    
    @FXML
    private TextArea ProductDescription;
    
    @FXML
    private Button AddProduct;

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("productstable");
    }

    @FXML
    protected void initialize() {
        if (UserId == null) {
            System.out.println("Error: choiceBoxHerria es null.");
            return;
        }
        List<String> users = ProductDendarenAtzipena.getUser_Id(); // Obtener lista de usuarios desde la base de datos
        List<String> categories = Arrays.asList(
            "footwear", "bottoms", "tops", "home-decor", 
            "elektrical-devices", "kitchen", "card-games", 
            "video-games", "board-games"
        );

        for(String category : categories) {
            choiceBoxCategories.getItems().add(category);
        }
        if (users == null || users.isEmpty()) {
            System.out.println("Error: No hay usuarios para cargar.");
            return;
        }
        for (String user : users) {
            UserId.getItems().add(user);  // Llenar el ChoiceBox con los usuarios disponibles
        }
    }

    @FXML
    void handleAddProducts() throws IOException {
        String userId = UserId.getValue();  // Obtener el ID de usuario seleccionado
        String name = ProductName.getText().trim();  // Obtener nombre del producto
        String price = ProductPrice.getText().trim();  // Obtener precio del producto
        String description = ProductDescription.getText().trim();
        String category = choiceBoxCategories.getValue();

        if (userId == null || userId.isEmpty() || price.isEmpty() || name.isEmpty() || description.isEmpty() || category == null || category.isEmpty()) {
            showAlert(AlertType.WARNING, "Missing Fields", "Please fill in all the fields.");
            return;
        }

        float priceFloat;
        try {
            priceFloat = Float.parseFloat(price);  // Convertir precio a float
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Invalid Price", "Please enter a valid number for the price.");
            return;
        }

        // Llamar al método para insertar el producto en la base de datos
        int result = ProductDendarenAtzipena.addProduct(userId, name, category, description, price);

        if (result == 1) {
            showAlert(AlertType.INFORMATION, "Success", "Product added successfully!");
            ProductName.clear();  // Limpiar los campos después de agregar el producto
            ProductPrice.clear();
            ProductDescription.clear();
            UserId.setValue(null);
        } else {
            showAlert(AlertType.ERROR, "Database Error", "Failed to add the product.");
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void handleUserId() {
        String username = userName.getText();  // Obtener el nombre de usuario del TextField
        String userID = ProductDendarenAtzipena.getUserId(username);  // Llamar a la base de datos para obtener el ID de usuario

        if (userID != null) {
            userIdLabel.setText("ID: " + userID);  // Si el ID existe, mostrarlo en el Label
        } else {
            userIdLabel.setText("User not found");  // Si no se encuentra el usuario, mostrar mensaje
        }
    }
}
