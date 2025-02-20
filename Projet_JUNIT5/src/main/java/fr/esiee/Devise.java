package fr.esiee;

public class Devise {
    private int quantite;
    private String monnaie;

    public Devise(int quantite, String monnaie) {
        this.quantite = quantite;
        this.monnaie = monnaie;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getMonnaie() {
        return monnaie;
    }

    // Ajout de l'exception dans la signature de la méthode
    public Devise add(Devise m) throws MonnaieDifferenteException {
        if (!this.monnaie.equals(m.getMonnaie())) {
            throw new MonnaieDifferenteException(this, m); // Levée de l'exception si monnaies différentes
        }
        return new Devise(this.quantite + m.getQuantite(), this.monnaie);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Devise devise = (Devise) obj;
        return quantite == devise.quantite && monnaie.equals(devise.monnaie);
    }

    @Override
    public String toString() {
        return quantite + " " + monnaie;
    }
}
