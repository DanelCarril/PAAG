package paagbat.controller;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paagbat.App;
import paagbat.model.NbaAtzipena;
import paagbat.model.base.Estatistika;
import paagbat.model.base.Jokalaria;
import paagbat.model.base.Taldea;

/**
 * Jokalarien estatistikak bistaratzea kudeatzen duen kontrolatzailea
 * erabiltzaile-interfazean, testu-eremu baten bidez.
 * Estatistikak puntuka, erreboteka edo asistentziaka ordenatzeko eta erakusteko aukera ematen du.
 */
public class EstatistikakTaula {

    NbaAtzipena nbaAtzipena = new NbaAtzipena("localhost", "nba_db", "estatistikak", "ikaslea", "ikaslea");

    @FXML
    TextArea textAreaEstatistikak;

    @FXML
    Label adminLabel;

    List<Jokalaria> jokalariak = nbaAtzipena.getJokalariak();

    /**
     * Kontrolagailua abiarazten du estatistikak datu-basetik kargatuz
     * eta testu-eremuan erakutsi behar dira.
     */
    @FXML
    protected void initialize() {
        String loggedErabiltzailea = LogIn.getLoggedErabiltzaile();
        adminLabel.setText("Admin: " + loggedErabiltzailea);

        textAreaEstatistikak.setEditable(false);

        List<Estatistika> estatistikak = nbaAtzipena.getEstatistikak();
        StringBuilder sb = new StringBuilder();

        sb.append("ESTATISTIKAK\n");

        for (Estatistika estatistika : estatistikak) {
            Jokalaria jokalaria = getJokalariaByIdFromList(jokalariak, estatistika.getJokalaria_id());

            sb.append(jokalaria.getIzena() + " " + jokalaria.getAbizena() + " ->  ")
            .append("p: " + estatistika.getPuntuak() + ",   ")
            .append("e: " + estatistika.getErreboteak() + ",    ")
            .append("a: " + estatistika.getAsistentziak());

            sb.append("\n");
            sb.append("---------------------------------------------------------");
            sb.append("\n");
        }

        textAreaEstatistikak.setText(sb.toString());
    }

    /**
     * Jokalari bat bilatzen du bere IDaren arabera, zerrenda baten barruan.
     *
     * @param jokalariak Jokalarien zerrenda.
     * @param id ID, jokalariarena.
     * @return Dagokion jokalaria edo, ez badago, null.
     */
    public Jokalaria getJokalariaByIdFromList(List<Jokalaria> jokalariak, int id) {
        for (Jokalaria j : jokalariak) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }

     /**
     * Estatistikak puntuka ordenatuta erakusten ditu, handienetik txikienera.
     */
    @FXML
    public void handlePuntuak() {
        textAreaEstatistikak.clear();
        List<Estatistika> estatistikak = nbaAtzipena.getEstatistikak();

        if (estatistikak != null && !estatistikak.isEmpty()) {
            estatistikak.sort((j1, j2) -> Float.compare(j2.getPuntuak(), j1.getPuntuak()));

            StringBuilder sb = new StringBuilder();
            sb.append("ESTATISTIKAK PUNTUAK\n");

            int i = 1;

            for (Estatistika estatistika : estatistikak) {
                Jokalaria jokalaria = getJokalariaByIdFromList(jokalariak, estatistika.getJokalaria_id());

                sb.append(i + ". " + jokalaria.getIzena() + " " + jokalaria.getAbizena() + " ->  ")
                .append("p: " + estatistika.getPuntuak() + ",   ")
                .append("e: " + estatistika.getErreboteak() + ",    ")
                .append("a: " + estatistika.getAsistentziak());

                sb.append("\n");
                sb.append("---------------------------------------------------------");
                sb.append("\n");

                i++;
            }

            textAreaEstatistikak.setText(sb.toString());
        } else {
            textAreaEstatistikak.setText("Ez dago jokalaririk.");
        }
    }

    /**
     * Estatistikak erreboteka ordenatuta erakusten ditu, handienetik txikienera.
     */
    @FXML
    public void handleErreboteak() {
        textAreaEstatistikak.clear();
        List<Estatistika> estatistikak = nbaAtzipena.getEstatistikak();

        if (estatistikak != null && !estatistikak.isEmpty()) {
            estatistikak.sort((j1, j2) -> Float.compare(j2.getErreboteak(), j1.getErreboteak()));

            StringBuilder sb = new StringBuilder();
            sb.append("ESTATISTIKAK ERREBOTEAK\n");

            int i = 1;

            for (Estatistika estatistika : estatistikak) {
                Jokalaria jokalaria = getJokalariaByIdFromList(jokalariak, estatistika.getJokalaria_id());

                sb.append(i + ". " + jokalaria.getIzena() + " " + jokalaria.getAbizena() + " ->  ")
                .append("p: " + estatistika.getPuntuak() + ",   ")
                .append("e: " + estatistika.getErreboteak() + ",    ")
                .append("a: " + estatistika.getAsistentziak());

                sb.append("\n");
                sb.append("---------------------------------------------------------");
                sb.append("\n");

                i++;
            }

            textAreaEstatistikak.setText(sb.toString());
        } else {
            textAreaEstatistikak.setText("Ez dago jokalaririk.");
        }
    }

    /**
     * Estatistikak asistentziaka ordenatuta erakusten ditu, handienetik txikienera.
     */
    @FXML
    public void handleAsistentziak() {
        textAreaEstatistikak.clear();
        List<Estatistika> estatistikak = nbaAtzipena.getEstatistikak();

        if (estatistikak != null && !estatistikak.isEmpty()) {
            estatistikak.sort((j1, j2) -> Float.compare(j2.getAsistentziak(), j1.getAsistentziak()));

            StringBuilder sb = new StringBuilder();
            sb.append("ESTATISTIKAK ASISTENTZIAK\n");

            int i = 1;

            for (Estatistika estatistika : estatistikak) {
                Jokalaria jokalaria = getJokalariaByIdFromList(jokalariak, estatistika.getJokalaria_id());

                sb.append(i + ". " + jokalaria.getIzena() + " " + jokalaria.getAbizena() + " ->  ")
                .append("p: " + estatistika.getPuntuak() + ",   ")
                .append("e: " + estatistika.getErreboteak() + ",    ")
                .append("a: " + estatistika.getAsistentziak());

                sb.append("\n");
                sb.append("---------------------------------------------------------");
                sb.append("\n");

                i++;
            }

            textAreaEstatistikak.setText(sb.toString());
        } else {
            textAreaEstatistikak.setText("Ez dago jokalaririk.");
        }
    }

    /**
     * Estatistiken bista jatorrizko egoerara berrezartzen du (ordenatu gabe).
     */
    @FXML
    public void handleDenak() {
        textAreaEstatistikak.clear();
        initialize();
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
