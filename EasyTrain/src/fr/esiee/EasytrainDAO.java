/*

package fr.esiee;


import fr.esiee.dao.ArretDAO;
import fr.esiee.model.Arret;

import java.util.List;

public class EasytrainDAO {
    public static void main(String[] args) {
        ArretDAO arretDAO = new ArretDAO();

        // 1. Ajouter un nouvel arrêt
        Arret newArret = new Arret(0, "Gare Centrale"); // L'id sera auto-incrémenté
        arretDAO.addArret(newArret);

        // 2. Récupérer tous les arrêts
        List<Arret> arrets = arretDAO.getAllArrets();
        System.out.println("Liste des arrêts:");
        for (Arret arret : arrets) {
            System.out.println("ID: " + arret.getId() + ", Nom: " + arret.getNom());
        }

        // 3. Récupérer un arrêt par ID
        int idToFetch = 1; // Remplacez par l'ID d'un arrêt existant
        Arret fetchedArret = arretDAO.getArretById(idToFetch);
        if (fetchedArret != null) {
            System.out.println("Arrêt récupéré: ID: " + fetchedArret.getId() + ", Nom: " + fetchedArret.getNom());
        } else {
            System.out.println("Aucun arrêt trouvé avec l'ID: " + idToFetch);
        }

        // 4. Supprimer un arrêt
        int idToDelete = 1; // Remplacez par l'ID d'un arrêt à supprimer
        arretDAO.deleteArret(idToDelete);
        System.out.println("Arrêt avec ID " + idToDelete + " supprimé.");
    }
}
*/
