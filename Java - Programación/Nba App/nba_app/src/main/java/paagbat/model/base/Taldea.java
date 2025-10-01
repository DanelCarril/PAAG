package paagbat.model.base;

public class Taldea {
    private int id;
    private String taldeIzena;
    private String hiria;
    private String entrenatzailea;
    private String conference;
    private String estadioa;

    public Taldea(int id, String taldeIzena, String hiria, String entrenatzailea, String conference, String estadioa) {
        this.id = id;
        this.taldeIzena = taldeIzena;
        this.hiria = hiria;
        this.entrenatzailea = entrenatzailea;
        this.conference = conference;
        this.estadioa = estadioa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaldeIzena() {
        return taldeIzena;
    }

    public void setTaldeIzena(String taldeIzena) {
        this.taldeIzena = taldeIzena;
    }

    public String getHiria() {
        return hiria;
    }

    public void setHiria(String hiria) {
        this.hiria = hiria;
    }

    public String getEntrenatzailea() {
        return entrenatzailea;
    }

    public void setEntrenatzailea(String entrenatzailea) {
        this.entrenatzailea = entrenatzailea;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getEstadioa() {
        return estadioa;
    }

    public void setEstadioa(String estadioa) {
        this.estadioa = estadioa;
    }

    @Override
    public String toString() {
        return taldeIzena; // O getTaldeIzena(), según cómo lo tengas
    }
}
