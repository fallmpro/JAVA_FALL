package fr.esiee.model;


import java.time.LocalDateTime;

public class Trajet {
    private String code;
    private LocalDateTime tempsDepart;
    private LocalDateTime tempsArrivee;


    public Trajet(String code, LocalDateTime tempsDepart, LocalDateTime tempsArrivee) {
        this.code = code;
        this.tempsDepart = tempsDepart;
        this.tempsArrivee = tempsArrivee;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTempsDepart() {
        return tempsDepart;
    }

    public void setTempsDepart(LocalDateTime tempsDepart) {
        this.tempsDepart = tempsDepart;
    }

    public LocalDateTime getTempsArrivee() {
        return tempsArrivee;
    }

    public void setTempsArrivee(LocalDateTime tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }
}
