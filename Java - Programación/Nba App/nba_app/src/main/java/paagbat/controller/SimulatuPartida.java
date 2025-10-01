package paagbat.controller;

import java.io.IOException;
import javafx.util.Duration;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Jokalaria;
import paagbat.model.base.Partida;
import paagbat.model.base.Taldea;

public class SimulatuPartida {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "partida", "ikaslea", "ikaslea");

    private List<Taldea> taldeak;

    @FXML
    private ChoiceBox<String> choiceBoxBertakoa;

    @FXML
    private ChoiceBox<String> choiceBoxKanpokoa;

    @FXML
    private Label bertakoaLabel;

    @FXML
    private Label kanpokoaLabel;

    @FXML
    private Label bertakoPuntuak;

    @FXML
    private Label kanpokoPuntuak;

    @FXML
    private TextArea textAreaSimulatuta;

    @FXML
    private Button aukeraButton;

    private int puntosBertakoa = 0;
    private int puntosKanpokoa = 0;
    private Timeline timeline;
    private int iteracionActual = 0;
    private final int MAX_ITERACIONES = 60;

    @FXML
    protected void initialize() {
        taldeak = nbaAtzipena.getTaldeak();

        ObservableList<String> listaNombres = FXCollections.observableArrayList();

        for (Taldea t : taldeak) {
            listaNombres.add(t.getTaldeIzena());
        }

        choiceBoxBertakoa.setItems(listaNombres);
        choiceBoxKanpokoa.setItems(listaNombres);

        if (taldeak.size() > 1) {
            choiceBoxBertakoa.setValue(taldeak.get(0).getTaldeIzena());
            choiceBoxKanpokoa.setValue(taldeak.get(1).getTaldeIzena());
        }
    }

    public double irabazlePropabilitatea(String taldea1Izena, String taldea2Izena) {
        int taldea1Id = nbaAtzipena.getTaldeIdByName(taldea1Izena);
        int taldea2Id = nbaAtzipena.getTaldeIdByName(taldea2Izena);

        if (taldea1Id == -1 || taldea2Id == -1) {
            return 0.5;
        }

        List<Partida> partidas = nbaAtzipena.partidasEntre(taldea1Id, taldea2Id);
        int winsTalde1 = 0;
        int winsTalde2 = 0;

        for (Partida p : partidas) {
            int ganadorId = -1;
            if (p.getBertako_puntuak() > p.getKanpoko_puntuak()) {
                ganadorId = p.getBertako_taldea_id();
            } else if (p.getKanpoko_puntuak() > p.getBertako_puntuak()) {
                ganadorId = p.getKanpoko_taldea_id();
            }

            if (ganadorId == taldea1Id)
                winsTalde1++;
            else if (ganadorId == taldea2Id)
                winsTalde2++;
        }

        int total = winsTalde1 + winsTalde2;
        if (total == 0) {
            return 0.5;
        }
    
        return (double) winsTalde1 / total;
    }

    @FXML
    public void handleAukeratu() {
        aukeraButton.setDisable(true);

        String bertakoa = choiceBoxBertakoa.getValue();
        String kanpokoa = choiceBoxKanpokoa.getValue();

        if (bertakoa.equals(kanpokoa)) {
            textAreaSimulatuta.setText("Aukeratu bi talde desberdin.");
            aukeraButton.setDisable(false);
            return;
        }

        bertakoaLabel.setText(bertakoa);
        kanpokoaLabel.setText(kanpokoa);

        partidaSimulatu(bertakoa, kanpokoa);
    }

    public void partidaSimulatu(String bertakoa, String kanpokoa) {
        puntosBertakoa = 0;
        puntosKanpokoa = 0;
        iteracionActual = 0;
        bertakoPuntuak.setText("0");
        kanpokoPuntuak.setText("0");
        textAreaSimulatuta.clear();

        double probabilidadBertakoa = irabazlePropabilitatea(bertakoa, kanpokoa);

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            if (iteracionActual >= MAX_ITERACIONES) {
                timeline.stop();
                aukeraButton.setDisable(false);
                textAreaSimulatuta.appendText("\n--- PARTIDAREN AMAIERA ---\n");
                textAreaSimulatuta.appendText("Emaitza: " + puntosBertakoa + " - " + puntosKanpokoa);
                return;
            }

            boolean bertakoaAnota = Math.random() < probabilidadBertakoa;
            int puntuak = (int) (Math.random() * 4);

            if (bertakoaAnota) {
                puntosBertakoa += puntuak;
                bertakoPuntuak.setText(String.valueOf(puntosBertakoa));
                if (puntuak > 0)
                    textAreaSimulatuta.appendText(bertakoa + " " + puntuak + " puntu sartu ditu.\n");
                else
                    textAreaSimulatuta.appendText(bertakoa + " ez du sartu.\n");
            } else {
                puntosKanpokoa += puntuak;
                kanpokoPuntuak.setText(String.valueOf(puntosKanpokoa));
                if (puntuak > 0)
                    textAreaSimulatuta.appendText(kanpokoa + " " + puntuak + " puntu sartu ditu.\n");
                else
                    textAreaSimulatuta.appendText(kanpokoa + " ez du sartu.\n");
            }

            iteracionActual++;
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void handleReturn() throws IOException {
        App.setRoot("partidakTaula");
    }
}
