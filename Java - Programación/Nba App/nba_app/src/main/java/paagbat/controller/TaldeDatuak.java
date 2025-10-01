package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Jokalaria;
import paagbat.model.base.Taldea;

/**
 * Ekipo baten datu zehatzak ikusteko kontrolagailua.
 * Hautatutako ekipo bati buruzko informazio zehatza bistaratzeko aukera ematen du.
 * jokalariak, entrenatzailea, hiria eta estadioa barne.
*/
public class TaldeDatuak {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "jokalaria", "ikaslea", "ikaslea");

    /** Datuak erakutsiko dituen hautatutako ekipoa.*/
    private Taldea aukeratutakoTaldea;

    @FXML
    Label taldearenIzena;

    @FXML
    TextArea textAreaDatuak;

    @FXML
    Label adminLabel;

    /**
     * Ekipo baten datuen ikuspegia abiarazten du, eta
     * egungo administratzailea erabiltzailearen interfazean.
    */
    @FXML
    protected void initialize() {
        String loggedErabiltzailea = LogIn.getLoggedErabiltzaile();
        adminLabel.setText("Admin: " + loggedErabiltzailea);
    }

    /**
     * Hautatutako ekipoa ezartzen du eta testu-eremuan kargatzen ditu bere datuak.
     * Taldeko jokalariak, entrenatzailea, hiria eta estadioa erakusten ditu.
     *
     * @param talde Xehetasunetan erakutsiko den hautatutako taldea.
    */
    public void setAukeratutakoTaldea(Taldea talde) {
        this.aukeratutakoTaldea = talde;
        textAreaDatuak.setEditable(false);
        
        taldearenIzena.setText(aukeratutakoTaldea.getTaldeIzena());

        int taldearenId = aukeratutakoTaldea.getId();


        List<Jokalaria> jokalariak = nbaAtzipena.getJokalariakTaldean(taldearenId);

        System.out.println("Número de jugadores: " + jokalariak.size());

        if (jokalariak != null && !jokalariak.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jokalariak\n");

            for (Jokalaria j : jokalariak) {
                sb.append("   · ")
                .append(j.getIzena())
                .append(" ")
                .append(j.getAbizena())
                .append(" (")
                .append(j.getPosizioa())
                .append(", ")
                .append(j.getAdina())
                .append(")\n");
            }

            sb.append("\nEntrenatzailea\n");
            sb.append("   · ").append(aukeratutakoTaldea.getEntrenatzailea());
            sb.append("\n");

            sb.append("\nHiria\n");
            sb.append("   · ").append(aukeratutakoTaldea.getHiria());
            sb.append("\n");

            sb.append("\nEstadioa\n");
            sb.append("   · ").append(aukeratutakoTaldea.getEstadioa());

            textAreaDatuak.setText(sb.toString());
        }
    }

    /**
     * Itzuli ekipoen taula ikustera.
     *
     * @throws IOException, ekipoen bista kargatzean errore bat gertatzen bada.
    */
    @FXML
    private void handleReturn() throws IOException {
        App.setRoot("taldeakTaula");
    }
}

