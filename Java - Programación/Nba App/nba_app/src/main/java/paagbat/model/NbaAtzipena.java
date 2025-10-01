package paagbat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paagbat.model.base.Estatistika;
import paagbat.model.base.Jokalaria;
import paagbat.model.base.Partida;
import paagbat.model.base.Taldea;

public class NbaAtzipena {
    private String server;
    private String db;
    private String taula;

    String user;
    String pass;

    public NbaAtzipena(String server, String db, String taula, String user, String pass) {
        this.server = server;
        this.db = db;
        this.taula = taula;
        this.user = user;
        this.pass = pass;
    }

    public Connection konektatu() {
        String url = "jdbc:mariadb://" + server + "/" + db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println(server + " zerbidoreko " + db + " datu-basera konektatu zara.");
        } catch (SQLException e) {
            if (e.getErrorCode() == 1045)
                System.out.println("Erabiltzaile edo pasahitz okerrak");
            else if (e.getErrorCode() == 0)
                System.out.println("Ezin zerbitzariarekin konektatu");
            else
                System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
        return conn;
    }

    public List<Taldea> getTaldeak() {
        String sql = "SELECT * FROM taldea ORDER BY izena ASC";
        List<Taldea> taldeLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                taldeLista.add(new Taldea(rs.getShort("id"), rs.getString("izena"), rs.getString("hiria"),
                        rs.getString("entrenatzailea"), rs.getString("conference"), rs.getString("estadioa")));
            }
            return taldeLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Taldea> getTaldeaConference(String conference) {
        String sql = "SELECT * FROM taldea WHERE conference = ?";
        List<Taldea> taldeLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, conference);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                taldeLista.add(new Taldea(rs.getShort("id"), rs.getString("izena"), rs.getString("hiria"),
                        rs.getString("entrenatzailea"), rs.getString("conference"), rs.getString("estadioa")));
            }
            return taldeLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Jokalaria> getJokalariakTaldean(int taldeId) {
        String sql = "SELECT * FROM jokalaria WHERE taldea_id = ?";
        List<Jokalaria> jokalariak = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taldeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                jokalariak.add(new Jokalaria(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
                        rs.getString("posizioa"), rs.getInt("adina"), rs.getInt("taldea_id")));
            }
            return jokalariak;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Jokalaria> getJokalariak() {
        String sql = "SELECT * FROM jokalaria";
        List<Jokalaria> jokalariLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                jokalariLista.add(new Jokalaria(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
                        rs.getString("posizioa"), rs.getInt("adina"), rs.getInt("taldea_id")));
            }
            return jokalariLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Jokalaria> getJokalariaTaldea(String taldea) {
        String sql = "SELECT jokalaria.* FROM jokalaria INNER JOIN taldea ON jokalaria.taldea_id = taldea.id WHERE taldea.izena = ?";
        List<Jokalaria> jokalariLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, taldea);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                jokalariLista.add(new Jokalaria(rs.getInt("id"), rs.getString("izena"), rs.getString("abizena"),
                        rs.getString("posizioa"), rs.getInt("adina"), rs.getInt("taldea_id")));
            }
            return jokalariLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> erabiltzaileBalidatu(String erabiltzailea, String pasahitza) {
        List<String> userData = new ArrayList<>();
        String sql = "SELECT erabiltzailea FROM erabiltzaileak WHERE erabiltzailea = ? AND pasahitza = ?";

        try (Connection conn = konektatu();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userData.add(rs.getString("erabiltzailea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userData;
    }

    public List<Partida> getPartidak() {
        String sql = "SELECT * FROM partida";
        List<Partida> partidaLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                partidaLista.add(new Partida(rs.getInt("id"), rs.getInt("bertako_taldea_id"),
                        rs.getInt("kanpoko_taldea_id"), rs.getInt("bertako_puntuak"), rs.getInt("kanpoko_puntuak"),
                        rs.getString("data_partida"), rs.getString("jokatuta")));
            }
            return partidaLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Partida> getPartidakFiltratuta(Integer taldeId, String jokatuta, String data) {
        StringBuilder sql = new StringBuilder("SELECT * FROM partida WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (taldeId != null && taldeId > 0) {
            sql.append(" AND (bertako_taldea_id = ? OR kanpoko_taldea_id = ?)");
            params.add(taldeId);
            params.add(taldeId);
        }

        if (jokatuta != null && !jokatuta.equalsIgnoreCase("All")) {
            sql.append(" AND jokatuta = ?");
            params.add(jokatuta);
        }

        if (data != null && !data.isEmpty()) {
            sql.append(" AND data_partida = ?");
            params.add(data);
        }

        List<Partida> partidak = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                partidak.add(new Partida(
                        rs.getInt("id"),
                        rs.getInt("bertako_taldea_id"),
                        rs.getInt("kanpoko_taldea_id"),
                        rs.getInt("bertako_puntuak"),
                        rs.getInt("kanpoko_puntuak"),
                        rs.getString("data_partida"),
                        rs.getString("jokatuta")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partidak;
    }

    public List<Estatistika> getEstatistikak() {
        String sql = "SELECT * FROM estatistikak";
        List<Estatistika> estatistikaLista = new ArrayList<>();

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                estatistikaLista.add(new Estatistika(rs.getInt("id"), rs.getInt("jokalaria_id"), rs.getFloat("puntuak"),
                        rs.getFloat("erreboteak"), rs.getFloat("asistentziak")));
            }
            return estatistikaLista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getTaldeIdByName(String taldeaIzena) {
        String sql = "SELECT id FROM taldea WHERE izena = ?";
        try (Connection conn = konektatu();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, taldeaIzena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public Partida getPartida(int bertakoaId, int kanpokoaId, String data) {
        String sql = "SELECT * FROM partida WHERE bertako_taldea_id = ? AND kanpoko_taldea_id = ? AND data_partida = ?";

        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, bertakoaId);
            pstmt.setInt(2, kanpokoaId);
            pstmt.setString(3, data);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Partida(
                        rs.getInt("id"),
                        rs.getInt("bertako_taldea_id"),
                        rs.getInt("kanpoko_taldea_id"),
                        rs.getInt("bertako_puntuak"),
                        rs.getInt("kanpoko_puntuak"),
                        rs.getString("data_partida"),
                        rs.getString("jokatuta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la partida: " + e.getMessage());
        }
        return null;
    }

    public boolean eguneratuPartida(Partida partida) {
        String sql = "UPDATE partida SET bertako_puntuak = ?, kanpoko_puntuak = ?, data_partida = ?, jokatuta = ? WHERE id = ?";
        try (Connection conn = konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, partida.getBertako_puntuak());
            pstmt.setInt(2, partida.getKanpoko_puntuak());
            pstmt.setString(3, partida.getData_partida());
            pstmt.setString(4, partida.getJokatuta());
            pstmt.setInt(5, partida.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Partida> partidasEntre(int taldea1, int taldea2) {
        List<Partida> partidas = new ArrayList<>();
        String sql = "SELECT * FROM partida WHERE (bertako_taldea_id = ? AND kanpoko_taldea_id = ?) OR (bertako_taldea_id = ? AND kanpoko_taldea_id = ?)";

        try (Connection conn = konektatu();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, taldea1);
            stmt.setInt(2, taldea2);
            stmt.setInt(3, taldea2);
            stmt.setInt(4, taldea1);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Partida p = new Partida(
                        rs.getInt("id"),
                        rs.getInt("bertako_taldea_id"),
                        rs.getInt("kanpoko_taldea_id"),
                        rs.getInt("bertako_puntuak"),
                        rs.getInt("kanpoko_puntuak"),
                        rs.getString("data_partida"),
                        rs.getString("jokatuta"));
                partidas.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidas;
    }

}
