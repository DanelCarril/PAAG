package paagbat.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Taldea;

/**
 * Ekipoak ikusteko kontrolagailua (Taldeak).
 * Saskibaloiko talde guztiak ikusteko eta konferentziaren arabera iragazteko aukera ematen du.
*/
public class TaldeakTaula {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "taldea", "ikaslea", "ikaslea");

    @FXML
    TableView<Taldea> tableViewTaldeak;

    @FXML
    private TableColumn<Taldea,String> tableColumnIzena;

    @FXML
    private TableColumn<Taldea, String> tableColumnConference;

    @FXML
    private TableColumn<Taldea, String> tableColumnEntrenatzailea;

    @FXML
    ChoiceBox<String> choiceConference;

    @FXML
    Label adminLabel;

    /**
    * Ekipoen bista abiarazten du. Ekipo guztiak datu-basetik kargatzen ditu
    * eta konferentzia-iragazkiak konfiguratzen ditu.
    */
    @FXML
    protected void initialize() {
        String loggedErabiltzailea = LogIn.getLoggedErabiltzaile();
        adminLabel.setText("Admin: " + loggedErabiltzailea);

        ObservableList<Taldea> taldeak = FXCollections.observableArrayList(nbaAtzipena.getTaldeak());

        tableViewTaldeak.setItems(taldeak);

        tableColumnIzena.setCellValueFactory(new PropertyValueFactory<Taldea, String>("taldeIzena"));
        tableColumnConference.setCellValueFactory(new PropertyValueFactory<Taldea, String>("conference"));
        tableColumnEntrenatzailea.setCellValueFactory(new PropertyValueFactory<Taldea, String>("entrenatzailea"));

        List<String> conferenceAll = Arrays.asList("All", "Eastern", "Western");
        for (String conference : conferenceAll) {
            choiceConference.getItems().add(conference);
        }

        choiceConference.setOnAction(event -> {
            String confI = choiceConference.getValue();

            if (confI.equals("Eastern") || confI.equals("Western")) {
                ObservableList<Taldea> taldeakConf = FXCollections.observableArrayList(nbaAtzipena.getTaldeaConference(confI));
                tableViewTaldeak.setItems(taldeakConf);
            } else {
                tableViewTaldeak.setItems(taldeak);
            }
        });
    }

    /**
    * Hautatutako ekipo baten datu zehatzak bistaratzeko ekintza erabiltzen du.
    * Hautatutako ekipoaren datuen bista kargatzen du, ekipo bat aukeratuta badago.
    * Ekipo bat aukeratzen ez bada, ohartarazpen-alerta bat erakutsiko du.
    *
    * @throws IOException, bista berria kargatzean errorea gertatzen bada.
    */
    @FXML
    private void handleDatuak() throws IOException {
        Taldea aukeratua = tableViewTaldeak.getSelectionModel().getSelectedItem();

        if (aukeratua != null) {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("taldeDatuak.fxml"));
            Parent root = loader.load();

            TaldeDatuak controller = loader.getController();
            controller.setAukeratutakoTaldea(aukeratua);

            App.scene.setRoot(root);
        } else {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Garrantzitsua");
            alerta.setHeaderText("¡Aukeratu!");
            alerta.setContentText("Talde bat aukeratu behar duzu");

            // Mostrar la alerta
            alerta.showAndWait();
        }
    }

    /**
     * Itzuli menu nagusira.
     *
     * @throws IOException, bista berria kargatzean errorea gertatzen bada.
    */
    @FXML
    private void handleReturn() throws IOException {
        App.setRoot("mainMenu");
    }
}
