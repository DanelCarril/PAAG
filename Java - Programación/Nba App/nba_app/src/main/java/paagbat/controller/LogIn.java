package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import paagbat.App;
import paagbat.model.NbaAtzipena;


/**
 * Saioa hasteko pantailarako kontrolagailua.
 * Erabiltzaile bat datu-basearen aurka balidatzeko eta menu nagusira sartzeko aukera ematen du.
 */
public class LogIn {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "erabiltzaileak", "ikaslea", "ikaslea");

    @FXML
    TextField erabiltzaileaField;

    @FXML
    PasswordField pasahitzaField;

    /** Saioa behar bezala hasi duen erabiltzailea.*/
    private static String loggedErabiltzailea;

    /**
     * Log-in gertaera maneiatzen du.
     * Balidatu sartutako datuak eta birbideratu menu nagusira, zuzenak badira.
     *
     * @throws IOException, errore bat gertatzen bada hurrengo bista kargatzean.
     */
    @FXML
    private void handleLogIn() throws IOException {
        String erabiltzailea = erabiltzaileaField.getText();
        String pasahitza = pasahitzaField.getText();

        List<String> erabiltzaileDatuak = nbaAtzipena.erabiltzaileBalidatu(erabiltzailea, pasahitza);

        if (erabiltzaileDatuak != null && !erabiltzaileDatuak.isEmpty()) {
            loggedErabiltzailea = erabiltzailea;
            App.setRoot("editatuPartida");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Log-in");
            alert.setHeaderText("Log in ez da zuzena");
            alert.setContentText("Erabiltzailea edo pashitza ez da zuzena");
            alert.showAndWait();
        }
    }

    /**
     * Aplikazioa erabat ixten du.
     *
     * @throws IOException errore bat gertatzen bada (arraroa testuinguru honetan, baina koherentziagatik mantentzen da).
    */
    @FXML
    private void exit() throws IOException {
        App.setRoot("mainMenu");
    }

    /**
     * Erabiltzaile-eremua eta pasahitza garbitzen ditu.
    */
    @FXML
    private void handleEzabatu() {
        erabiltzaileaField.clear();
        pasahitzaField.clear();
    }

    /**
     * Saioa hasi duen erabiltzailearen izena itzultzen du.
     *
     * @return Gaur egun logueatuta dagoen erabiltzailearen izena.
    */
    public static String getLoggedErabiltzaile() {
        return loggedErabiltzailea;
    }
}
