package paagbat.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import paagbat.App;
import paagbat.model.DendarenAtzipena;
import paagbat.model.base.SalesBase;

public class Sales {
    @FXML
    TableView<SalesBase> tableViewSales;

    @FXML
    private TableColumn<SalesBase, String> tableColumnId;
    @FXML
    private TableColumn<SalesBase, String> tableColumnUserId;
    @FXML
    private TableColumn<SalesBase, String> tableColumnProductId;

    DendarenAtzipena dendarenAtzipena = new DendarenAtzipena("localhost", "challenge_3_database", "sales", "ikaslea", "ikaslea");

    @FXML
    protected void initialize() {
        ObservableList<SalesBase> salesList = FXCollections.observableArrayList(dendarenAtzipena.getAllSales());

        tableColumnId.prefWidthProperty().bind(tableViewSales.widthProperty().multiply(0.33));
        tableColumnUserId.prefWidthProperty().bind(tableViewSales.widthProperty().multiply(0.33));
        tableColumnProductId.prefWidthProperty().bind(tableViewSales.widthProperty().multiply(0.33));

        tableViewSales.setItems(salesList);

        tableColumnId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        tableColumnUserId.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        tableColumnProductId.setCellValueFactory(cellData -> cellData.getValue().productIdProperty());

        tableViewSales.setEditable(true);

        tableColumnId.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnUserId.setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumnProductId.setCellFactory(TextFieldTableCell.forTableColumn());

        tableColumnId.setOnEditCommit(event -> {
            SalesBase salesBase = event.getRowValue();
            salesBase.setId(event.getNewValue());
            dendarenAtzipena.updateSale(salesBase);
        });

        tableColumnUserId.setOnEditCommit(event -> {
            SalesBase salesBase = event.getRowValue();
            salesBase.setUserId(event.getNewValue());
            dendarenAtzipena.updateSale(salesBase);
        });

        tableColumnProductId.setOnEditCommit(event -> {
            SalesBase salesBase = event.getRowValue();
            salesBase.setProductId(event.getNewValue());
            dendarenAtzipena.updateSale(salesBase);
        });
    }

    @FXML
    void handleReturn() throws IOException {
        App.setRoot("chooseTable");
    }

    @FXML
    void handleAdd() throws IOException {
        App.setRoot("addSale");
    }

    @FXML
    void handleDelete() {
        SalesBase selectedSale = tableViewSales.getSelectionModel().getSelectedItem();
        
        if (selectedSale != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to delete this sale?");
            alert.setContentText("ID of the sale: " + selectedSale.getId());
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    dendarenAtzipena.deleteSale(selectedSale);
                    tableViewSales.getItems().remove(selectedSale);
                }
            });
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No sales were selected.");
            alert.setContentText("Please select a sale from the table to delete.");
            alert.showAndWait();
        }
    }
}
