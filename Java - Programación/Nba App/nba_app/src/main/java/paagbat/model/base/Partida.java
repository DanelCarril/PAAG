package paagbat.model.base;

public class Partida {
    private int id;
    private int bertako_taldea_id;
    private int kanpoko_taldea_id;
    private int bertako_puntuak;
    private int kanpoko_puntuak;
    private String data_partida;
    private String jokatuta;

    public Partida(int id, int bertako_taldea_id, int kanpoko_taldea_id, int bertako_puntuak, int kanpoko_puntuak,
            String data_partida, String jokatuta) {
        this.id = id;
        this.bertako_taldea_id = bertako_taldea_id;
        this.kanpoko_taldea_id = kanpoko_taldea_id;
        this.bertako_puntuak = bertako_puntuak;
        this.kanpoko_puntuak = kanpoko_puntuak;
        this.data_partida = data_partida;
        this.jokatuta = jokatuta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBertako_taldea_id() {
        return bertako_taldea_id;
    }

    public void setBertako_taldea_id(int bertako_taldea_id) {
        this.bertako_taldea_id = bertako_taldea_id;
    }

    public int getKanpoko_taldea_id() {
        return kanpoko_taldea_id;
    }

    public void setKanpoko_taldea_id(int kanpoko_taldea_id) {
        this.kanpoko_taldea_id = kanpoko_taldea_id;
    }

    public int getBertako_puntuak() {
        return bertako_puntuak;
    }

    public void setBertako_puntuak(int bertako_puntuak) {
        this.bertako_puntuak = bertako_puntuak;
    }

    public int getKanpoko_puntuak() {
        return kanpoko_puntuak;
    }

    public void setKanpoko_puntuak(int kanpoko_puntuak) {
        this.kanpoko_puntuak = kanpoko_puntuak;
    }

    public String getData_partida() {
        return data_partida;
    }

    public void setData_partida(String data_partida) {
        this.data_partida = data_partida;
    }

    public String getJokatuta() {
        return jokatuta;
    }

    public void setJokatuta(String jokatuta) {
        this.jokatuta = jokatuta;
    }
}
