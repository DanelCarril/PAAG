package paagbat.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import paagbat.App;

/**
 * Aplikazioaren menu nagusiaren kontrolatzailea.
 * Sistemaren atal desberdinetan nabigatzeko aukera ematen du: taldeak, jokalariak, partidak eta estatistikak.
*/
public class MainMenu {

    @FXML
    Label adminLabel;

    @FXML
    private void handleTaldeak() throws IOException {
        App.setRoot("taldeakTaula");
    }

    @FXML
    private void handleJokalariak() throws IOException {
        App.setRoot("jokalariakTaula");
    }

    @FXML
    private void handlePartidak() throws IOException {
        App.setRoot("partidakTaula");
    }

    @FXML
    private void handleEstatistikak() throws IOException {
        App.setRoot("estatistikakTaula");
    }

    /**
     * Saioa itxi eta login-pantailara itzultzen da.
     *
     * @throws IOException, ikusmena aldatzean akatsen bat gertatzen bada.
    */
    @FXML
    private void exit() throws IOException {
        Platform.exit();
    }
    
}
