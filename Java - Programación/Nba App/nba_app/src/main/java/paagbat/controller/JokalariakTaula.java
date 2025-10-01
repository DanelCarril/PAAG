package paagbat.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Jokalaria;
import paagbat.model.base.Taldea;

/**
 * Jokalarien taula ikusteko kontrolagailua.
 * Eskura dauden jokalariak erakusten ditu eta ChoiceBox baten bidez taldeka iragazteko aukera ematen du.
 */
public class JokalariakTaula {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "jokalaria", "ikaslea", "ikaslea");

    @FXML
    TableView<Jokalaria> tableViewJokalariak;

    @FXML
    private TableColumn<Jokalaria,String> tableColumnIzena;

    @FXML
    private TableColumn<Jokalaria, String> tableColumnAbizena;

    @FXML
    private TableColumn<Jokalaria, String> tableColumnPosizioa;

    @FXML
    ChoiceBox<String> choiceTeam;

    @FXML
    Label adminLabel;

    /**
     * Bista abiarazten du taula jokalariekin konfiguratuz,
     * zutabeak betez eta ChoiceBox konfiguratuz, ekipoaren arabera iragazteko.
     */
    @FXML
    protected void initialize() {
        String loggedErabiltzailea = LogIn.getLoggedErabiltzaile();
        adminLabel.setText("Admin: " + loggedErabiltzailea);

        ObservableList<Jokalaria> jokalariak = FXCollections.observableArrayList(nbaAtzipena.getJokalariak());

        tableViewJokalariak.setItems(jokalariak);

        // Taulari datuak esleitu
        tableColumnIzena.setCellValueFactory(new PropertyValueFactory<Jokalaria, String>("izena"));
        tableColumnAbizena.setCellValueFactory(new PropertyValueFactory<Jokalaria, String>("abizena"));
        tableColumnPosizioa.setCellValueFactory(new PropertyValueFactory<Jokalaria, String>("posizioa"));

        // Eskuragarri dauden ekipoen zerrenda
        List<String> teamAll = Arrays.asList(
            "All",
            "Hawks", "Celtics", "Nets", "Hornets", "Bulls",
            "Cavaliers", "Pistons", "Pacers", "Heat", "Bucks",
            "Knicks", "Magic", "76ers", "Raptors", "Wizards",
            "Mavericks", "Nuggets", "Warriors", "Rockets", "Clippers",
            "Lakers", "Grizzlies", "Timberwolves", "Pelicans", "Thunder",
            "Suns", "Trail Blazers", "Kings", "Spurs", "Jazz"
        );
        for (String team : teamAll) {
            choiceTeam.getItems().add(team);
        }

        choiceTeam.setOnAction(event -> {
            String teamI = choiceTeam.getValue();

            if (teamI.equals("All")) {
                tableViewJokalariak.setItems(jokalariak);
            } else {
                ObservableList<Jokalaria> jokalariakTeam = FXCollections.observableArrayList(nbaAtzipena.getJokalariaTaldea(teamI));
                tableViewJokalariak.setItems(jokalariakTeam);
            }
        });
    }

    /**
     * Aldatu ikuspegia menu nagusira.
     *
     * @throws IOException, bista kargatu ezin bada.
     */
    @FXML
    private void handleReturn() throws IOException {
        App.setRoot("mainMenu");
    }
}
