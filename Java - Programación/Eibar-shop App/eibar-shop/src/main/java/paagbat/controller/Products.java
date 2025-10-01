package paagbat.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.ProductsBase;

public class Products {

    @FXML
    TableView<ProductsBase> tableViewProducts;

    @FXML
    ChoiceBox<String> choiceSoldStock;

    @FXML
    private TableColumn<ProductsBase, String> tableColumnId;
    @FXML
    private TableColumn<ProductsBase, String> tableColumnUserId;
    @FXML
    private TableColumn<ProductsBase, String> tableColumnProductName;
    @FXML
    private TableColumn<ProductsBase, Float> tableColumnPrice;
    @FXML
    private TableColumn<ProductsBase, String> tableColumnProductDescription;

    DendarenAtzipena dendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "product", "ikaslea",
            "ikaslea");

    @FXML
    protected void initialize() {
        ObservableList<ProductsBase> productsList = FXCollections
                .observableArrayList(dendarenAtzipena.getAllProducts());

        tableColumnId.prefWidthProperty().bind(tableViewProducts.widthProperty().multiply(0.05));
        tableColumnUserId.prefWidthProperty().bind(tableViewProducts.widthProperty().multiply(0.09));
        tableColumnProductName.prefWidthProperty().bind(tableViewProducts.widthProperty().multiply(0.21));
        tableColumnPrice.prefWidthProperty().bind(tableViewProducts.widthProperty().multiply(0.10));
        tableColumnProductDescription.prefWidthProperty().bind(tableViewProducts.widthProperty().multiply(0.59));

        tableViewProducts.setItems(productsList);

        tableColumnId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        tableColumnUserId.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        tableColumnProductName.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
        tableColumnPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        tableColumnProductDescription.setCellValueFactory(cellData -> cellData.getValue().getDescription());

        tableViewProducts.setEditable(true);

        tableColumnProductName.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnPrice.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        tableColumnProductDescription.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnProductName.setOnEditCommit(event -> {
            ProductsBase product = event.getRowValue();
            product.setProductName(event.getNewValue());
            dendarenAtzipena.updateProduct(product);
        });

        tableColumnPrice.setOnEditCommit(event -> {
            ProductsBase product = event.getRowValue();
            product.setPrice(event.getNewValue());
            dendarenAtzipena.updateProduct(product);
        });

        tableColumnProductDescription.setOnEditCommit(event -> {
            ProductsBase product = event.getRowValue();
            product.setDescription(event.getNewValue());
            dendarenAtzipena.updateProduct(product);
        });

        List<String> statusAll = Arrays.asList( "in stock", "sold", "all");
        for (String status : statusAll) {
            choiceSoldStock.getItems().add(status);
        }

        choiceSoldStock.setOnAction(event -> {
            String statusI = choiceSoldStock.getValue();

            if (statusI == "all") {
                choiceSoldStock.getItems().clear();
                initialize();
            } else {
                ObservableList<ProductsBase> products = FXCollections.observableArrayList(dendarenAtzipena.getProductByStatus(statusI));
            
            tableViewProducts.setItems(products);

            tableColumnId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
            tableColumnUserId.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
            tableColumnProductName.setCellValueFactory(cellData -> cellData.getValue().productNameProperty());
            tableColumnPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
            tableColumnProductDescription.setCellValueFactory(cellData -> cellData.getValue().getDescription());
            }
        });
    }

    @FXML
    void handleReturn() throws IOException {
        App.setRoot("chooseTable");
    }

    @FXML
    void handleAddProducts() throws IOException {
        App.setRoot("addproducts");
    }

    @FXML
    void handleDelete() {
        ProductsBase selectedProduct = tableViewProducts.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to delete this product?");
            alert.setContentText("ID of the product: " + selectedProduct.getUserId());
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    dendarenAtzipena.deleteProduct(selectedProduct);
                    tableViewProducts.getItems().remove(selectedProduct);
                }
            });
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No product selected.");
            alert.setContentText("Please select a product to delete.");
            alert.showAndWait();
        }
    }
}
