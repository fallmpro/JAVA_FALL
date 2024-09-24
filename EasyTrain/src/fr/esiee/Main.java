package fr.esiee;

import fr.esiee.model.Arret;
import fr.esiee.model.Utilisateur;
import fr.esiee.model.Role;
import fr.esiee.model.Trajet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Arret arret1 = new Arret(8, "Cergy le Haut");
        System.out.println("Arret ID: " + arret1.getId() + ", Nom: " + arret1.getNom());


            Utilisateur utilisateur1 = new Utilisateur(1, "Hbk", "Momo", "hbkmomo", "momo123", LocalDate.of(2020, 1, 15), Role.ADMIN);
        System.out.println("Utilisateur ID: " + utilisateur1.getId() + ", Nom: " + utilisateur1.getPrenom() + " " + utilisateur1.getNom() +
                ", Role: " + utilisateur1.getRole());

        utilisateur1.setNom("Momo");
        utilisateur1.setLogin("hbkmomo");
        System.out.println("Nouvel utilisateur: " + utilisateur1.getLogin() + ", Nom: " + utilisateur1.getNom());

        Trajet trajet1 = new Trajet("T123", LocalDateTime.of(2023, 9, 20, 14, 30), LocalDateTime.of(2023, 9, 20, 16, 0));
        System.out.println("Trajet code: " + trajet1.getCode() + ", Temps de départ: " + trajet1.getTempsDepart() + ", Temps d'arrivée: " + trajet1.getTempsArrivee());


    }
}
