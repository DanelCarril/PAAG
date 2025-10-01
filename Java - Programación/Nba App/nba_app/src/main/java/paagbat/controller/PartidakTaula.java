package paagbat.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Partida;
import paagbat.model.base.Taldea;

/**
 * Partidak ikusteko kontrolatzailea.
 * Partida guztiak ikusteko eta taldearen, dataren eta jokatu diren ala ez ikusteko aukera ematen du.
*/
public class PartidakTaula {
    
    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "partida", "ikaslea", "ikaslea");

    @FXML
    ChoiceBox<String> choiceJokatuta;

    @FXML
    ChoiceBox<String> choiceTaldea;

    @FXML
    DatePicker partidaData;

    @FXML
    TextArea textAreaPartidak;

    List<Taldea> taldeak = nbaAtzipena.getTaldeak();

    /**
     * Bista hasten du, eta, horretarako, partidak kargatzen ditu eta ekipo- eta egoera-iragazkiak betetzen ditu.
    */
    @FXML
    protected void initialize() {
        textAreaPartidak.setEditable(false);

        List<Partida> partidak = nbaAtzipena.getPartidak();
        StringBuilder sb = new StringBuilder();

        for (Partida partida : partidak) {
            Taldea bertako = getTaldeaByIdFromList(taldeak, partida.getBertako_taldea_id());
            Taldea kanpoko = getTaldeaByIdFromList(taldeak, partida.getKanpoko_taldea_id());

            sb.append(bertako.getTaldeIzena())
            .append("   ")
            .append(partida.getBertako_puntuak())
            .append(" vs ")
            .append(partida.getKanpoko_puntuak())
            .append("   ")
            .append(kanpoko.getTaldeIzena());

            sb.append("\n")
            .append(partida.getData_partida())
            .append(" - ")
            .append(bertako.getEstadioa());

            sb.append("\n");
            sb.append("-------------------");
            sb.append("\n");
        }

        textAreaPartidak.setText(sb.toString());

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
            choiceTaldea.getItems().add(team);
        }

        List<String> jokoa = Arrays.asList("All", "Bai", "Ez");
        for (String joko : jokoa) {
            choiceJokatuta.getItems().add(joko);
        }
    }

    @FXML
    private void handleReturn() throws IOException {
        App.setRoot("mainMenu");
    }

    /**
     * ID bakoitzeko talde bat bilatzen du taldeen zerrenda batean.
     *
     * @param taldeak Taldeen zerrenda.
     * @param id ID, bilatu beharreko ekipoarena.
     * @ @return {@code Taldea} objektua, IDari dagokiona, edo {@code null} objektua ez badago.
    */
    public Taldea getTaldeaByIdFromList(List<Taldea> taldeak, int id) {
        for (Taldea t : taldeak) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * Bilatu talde bat izen bidez taldeen zerrenda batean.
     *
     * @param taldeak Taldeen zerrenda.
     * @param izena Taldearen izena.
     * @ @return {@code Taldea} objektua izen horrekin, edo {@code null} objektua ez badago.
    */
    public Taldea getTaldeaByIzenaFromList(List<Taldea> taldeak, String izena) {
        for (Taldea t : taldeak) {
            if (t.getTaldeIzena().equalsIgnoreCase(izena)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Partidak taldearen, dataren eta egoeraren arabera iragazten ditu (jokatu ala ez), eta TextArean erakusten ditu.
    */
    public void handleBistaratu() {
        textAreaPartidak.clear();
        
        String taldeHautatua = choiceTaldea.getValue();
        String jokatuta = choiceJokatuta.getValue();
        String dataStr = partidaData.getValue() != null ? partidaData.getValue().toString() : null;
    
        int taldeId = -1;
        if (taldeHautatua != null && !taldeHautatua.equalsIgnoreCase("All")) {
            Taldea taldeaObj = getTaldeaByIzenaFromList(taldeak, taldeHautatua);
            if (taldeaObj != null) {
                taldeId = taldeaObj.getId();
            }
        }
    
        List<Partida> partidaFiltratua = nbaAtzipena.getPartidakFiltratuta(taldeId, jokatuta, dataStr);
        StringBuilder sb = new StringBuilder();
    
        for (Partida partida : partidaFiltratua) {
            Taldea bertako = getTaldeaByIdFromList(taldeak, partida.getBertako_taldea_id());
            Taldea kanpoko = getTaldeaByIdFromList(taldeak, partida.getKanpoko_taldea_id());
    
            sb.append(bertako.getTaldeIzena())
              .append("   ")
              .append(partida.getBertako_puntuak())
              .append(" vs ")
              .append(partida.getKanpoko_puntuak())
              .append("   ")
              .append(kanpoko.getTaldeIzena())
              .append("\n")
              .append(partida.getData_partida())
              .append(" - ")
              .append(bertako.getEstadioa())
              .append("\n-------------------\n");
        }
    
        textAreaPartidak.setText(sb.toString());

        if (textAreaPartidak.getText().isEmpty()) {
            textAreaPartidak.setText("Ez dago partidarik filtro hauekin");
        }
    }
    
    public void handleGarbitu() {
        partidaData.setValue(null);
        choiceTaldea.setValue(null);
        choiceJokatuta.setValue(null);
        initialize();
    }

    @FXML
    public void handleSimulatu() throws IOException{
        App.setRoot("simulatuPartida");
    }

    @FXML
    public void handleEditatu() throws IOException {
        App.setRoot("logIn");
    }
}
