package paagbat.model.base;

public class Estatistika {
    private int id;
    private int jokalaria_id;
    private float puntuak;
    private float erreboteak;
    private float asistentziak;

    public Estatistika(int id, int jokalaria_id, float puntuak, float erreboteak, float asistentziak) {
        this.id = id;
        this.jokalaria_id = jokalaria_id;
        this.puntuak = puntuak;
        this.erreboteak = erreboteak;
        this.asistentziak = asistentziak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJokalaria_id() {
        return jokalaria_id;
    }

    public void setJokalaria_id(int jokalaria_id) {
        this.jokalaria_id = jokalaria_id;
    }

    public float getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(float puntuak) {
        this.puntuak = puntuak;
    }

    public float getErreboteak() {
        return erreboteak;
    }

    public void setErreboteak(float erreboteak) {
        this.erreboteak = erreboteak;
    }

    public float getAsistentziak() {
        return asistentziak;
    }

    public void setAsistentziak(float asistentziak) {
        this.asistentziak = asistentziak;
    }
}
