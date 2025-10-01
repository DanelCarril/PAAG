package paagbat.model.base;

public class Jokalaria {
    private int id;
    private String izena;
    private String abizena;
    private String posizioa;
    private int adina;
    private int taldea_id;

    public Jokalaria(int id, String izena, String abizena, String posizioa, int adina, int talde_id) {
        this.id = id;
        this.izena = izena;
        this.abizena = abizena;
        this.posizioa = posizioa;
        this.adina = adina;
        this.taldea_id = talde_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getAbizena() {
        return abizena;
    }

    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    public String getPosizioa() {
        return posizioa;
    }

    public void setPosizioa(String posizioa) {
        this.posizioa = posizioa;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public int getTaldea_id() {
        return taldea_id;
    }

    public void setTaldea_id(int talde_id) {
        this.taldea_id = talde_id;
    }
}
