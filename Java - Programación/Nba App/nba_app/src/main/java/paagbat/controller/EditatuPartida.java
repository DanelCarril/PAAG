package paagbat.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Partida;
import paagbat.model.base.Taldea;

public class EditatuPartida {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "partida", "ikaslea", "ikaslea");

    @FXML
    private ChoiceBox<Taldea> choiceBoxBertakoa;

    @FXML
    private ChoiceBox<Taldea> choiceBoxKanpokoa;

    @FXML
    private DatePicker datePickerData;

    @FXML
    private TextArea textAreaPartidak;

    @FXML
    private Button buttonAukeratu;

    private List<Taldea> taldeak;

    @FXML
    private Label labelBertakoa;
    @FXML
    private Label labelKanpokoa;
    @FXML
    private TextField fieldBertakoPuntuak;
    @FXML
    private TextField fieldKanpokoPuntuak;
    @FXML
    private DatePicker datePickerAldatu;

    private Partida partidaAktiboa;

    @FXML
    protected void initialize() {
        // Cargar lista de equipos
        taldeak = nbaAtzipena.getTaldeak();

        choiceBoxBertakoa.setItems(FXCollections.observableArrayList(taldeak));
        choiceBoxKanpokoa.setItems(FXCollections.observableArrayList(taldeak));

        if (!taldeak.isEmpty()) {
            choiceBoxBertakoa.setValue(taldeak.get(0));
            choiceBoxKanpokoa.setValue(taldeak.get(0));
        }
    }

    @FXML
    private void handleAukeratu() {
        Taldea bertakoa = choiceBoxBertakoa.getValue();
        Taldea kanpokoa = choiceBoxKanpokoa.getValue();
        LocalDate data = datePickerData.getValue();

        if (bertakoa == null || kanpokoa == null || data == null) {
            alert("Mesedez, aukeratu bi taldeak eta data.");
            return;
        }

        if (bertakoa.equals(kanpokoa)) {
            alert("Ezin dira bi talde berdinak aukeratu.");
            return;
        }

        int bertakoaId = nbaAtzipena.getTaldeIdByName(bertakoa.getTaldeIzena());
        int kanpokoaId = nbaAtzipena.getTaldeIdByName(kanpokoa.getTaldeIzena());

        String dataStr = data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Partida partida = nbaAtzipena.getPartida(bertakoaId, kanpokoaId, dataStr);

        if (partida == null) {
            alert("Ez dago partida hau aurkituta.");
            return;
        }

        partidaAktiboa = partida;

        labelBertakoa.setText(bertakoa.getTaldeIzena());
        labelKanpokoa.setText(kanpokoa.getTaldeIzena());
        fieldBertakoPuntuak.setText(String.valueOf(partida.getBertako_puntuak()));
        fieldKanpokoPuntuak.setText(String.valueOf(partida.getKanpoko_puntuak()));
        datePickerAldatu.setValue(LocalDate.parse(partida.getData_partida()));
    }

    @FXML
    private void handleGorde() {
        try {
            int berriaBertakoPuntuak = Integer.parseInt(fieldBertakoPuntuak.getText());
            int berriaKanpokoPuntuak = Integer.parseInt(fieldKanpokoPuntuak.getText());
            String berriaData = datePickerAldatu.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            String jokatuta = (berriaBertakoPuntuak > 0 || berriaKanpokoPuntuak > 0) ? "Bai" : "Ez";

            partidaAktiboa.setBertako_puntuak(berriaBertakoPuntuak);
            partidaAktiboa.setKanpoko_puntuak(berriaKanpokoPuntuak);
            partidaAktiboa.setData_partida(berriaData);
            partidaAktiboa.setJokatuta(jokatuta);

            boolean ondo = nbaAtzipena.eguneratuPartida(partidaAktiboa);

            if (ondo) {
                alert("Partida ondo eguneratu da.");
            } else {
                alert("Errorea gertatu da partida eguneratzean.");
            }

        } catch (NumberFormatException e) {
            alert("Mesedez, idatzi puntu balio egokiak.");
        }
    }


    private void alert(String mezua) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Gogoratu");
        alerta.setHeaderText(null);
        alerta.setContentText(mezua);
        alerta.showAndWait();
    }

    @FXML
    private void handleReturn() throws IOException {
        App.setRoot("partidakTaula");
    }
}
