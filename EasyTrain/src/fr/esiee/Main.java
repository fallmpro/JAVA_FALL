package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // URL, utilisateur et mot de passe pour la connexion à la base de données locale
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/easytrain";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // URL, utilisateur et mot de passe pour la connexion à la base de données distante
    private static final String RURL = "jdbc:mysql://mysql-fall.alwaysdata.net:3306/fall_easytrain";
    private static final String RUSER = "fall_";
    private static final String RPASSWORD = "mutillipwd";

    public static void main(String[] args) {
        // Créer un scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez la base de données : (1) Locale ou (2) Distante");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        // Variables pour stocker les paramètres de connexion
        String url, user, password;

        // Configurer les paramètres en fonction du choix
        if (choix == 1) {
            url = DB_URL;
            user = DB_USER;
            password = DB_PASSWORD;
        } else if (choix == 2) {
            url = RURL;
            user = RUSER;
            password = RPASSWORD;
        } else {
            System.out.println("Choix invalide, arrêt du programme.");
            return;
        }

        // Etablir une connexion à la base de données sélectionnée
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à la base de données.");

            // Affecter la connexion à la variable statique (simulé, ajuster selon votre implémentation)
            bddeasyline.DatabaseConnection = connection.getMetaData();

            // Demander à l'utilisateur d'entrer les informations
            System.out.println("Veuillez entrer votre login : ");
            String login = scanner.nextLine();

            System.out.println("Veuillez créer un mot de passe : ");
            String mdp = scanner.nextLine();

            System.out.println("Veuillez entrer votre nom : ");
            String nom = scanner.nextLine();

            System.out.println("Veuillez entrer votre prénom : ");
            String prenom = scanner.nextLine();

            System.out.println("Veuillez entrer votre date d'embauche (format : YYYY-MM-DD) : ");
            String dateEmbauche = scanner.nextLine();

            System.out.println("Veuillez entrer votre rôle (ADMIN ou EMPLOYEE) : ");
            String role = scanner.nextLine();

            // Insérer l'utilisateur avec les données fournies
            bddeasyline.ajouterUtilisateur(login, mdp, nom, prenom, dateEmbauche, role);

        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        } finally {
            // Fermer le scanner
            scanner.close();
        }
    }
}
