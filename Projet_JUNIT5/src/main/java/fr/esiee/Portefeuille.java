package fr.esiee;

import java.util.HashMap;

public class Portefeuille {
    private HashMap<String, Devise> contenu;

    public Portefeuille() {
        contenu = new HashMap<>();
    }

    public HashMap<String, Devise> getContenu() {
        return contenu;
    }

    public void ajouteDevise(Devise d) {
        String monnaie = d.getMonnaie();

        if (contenu.containsKey(monnaie)) {
            Devise ancienneDevise = contenu.get(monnaie);
            try {
                Devise nouvelleDevise = ancienneDevise.add(d);
                contenu.put(monnaie, nouvelleDevise);
            } catch (MonnaieDifferenteException e) {
                // Ce cas ne devrait jamais arriver puisque les monnaies sont les mêmes
                System.err.println("Erreur inattendue : " + e.getMessage());
            }
        } else {
            contenu.put(monnaie, d);
        }
    }
}
