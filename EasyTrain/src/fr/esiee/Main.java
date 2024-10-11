package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // URL, utilisateur et mot de passe pour la connexion à la base de données
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/easytrain";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        // Etablir une connexion à la base de données
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Affecter la connexion à la variable statique
            bddeasyline.DatabaseConnection = connection.getMetaData();

            // Créer un scanner pour lire les entrées de l'utilisateur
            Scanner scanner = new Scanner(System.in);

            // Demander à l'utilisateur d'entrer les informations
            System.out.println("Veuillez entrer votre login : ");
            String login = scanner.nextLine();

            System.out.println("Veuillez créer mot de passe : ");
            String mdp = scanner.nextLine();

            System.out.println("Veuillez entrer votre nom : ");
            String nom = scanner.nextLine();

            System.out.println("Veuillez entrer votre prénom : ");
            String prenom = scanner.nextLine();

            System.out.println("Veuillez entrer votre date d'embauche (format : YYYY-MM-DD) : ");
            String dateEmbauche = scanner.nextLine();

            System.out.println("Veuillez entrer votre rôle (ADMIN OU EMPLOYEE) : ");
            String role = scanner.nextLine();

            // Insérer l'utilisateur avec les données fournies
            bddeasyline.ajouterUtilisateur(login, mdp, nom, prenom, dateEmbauche, role);

            // Fermer le scanner
            scanner.close();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
