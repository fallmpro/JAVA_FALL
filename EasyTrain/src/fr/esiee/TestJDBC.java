package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {

    public static void main(String[] args) {

        String userLocal = "root";
        String pwdLocal = "";
        String urlLocal = "jdbc:mariadb://localhost:3306/easytrain";

        String userRemote = "fall_";
        String pwdRemote = "mutillipwd";
        String urlRemote = "jdbc:mysql://mysql-fall.alwaysdata.net:3306/fall_easytrain";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez la base de données : (1) Locale ou (2) Distante");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        String url, user, password;

        if (choix == 1) {
            url = urlLocal;
            user = userLocal;
            password = pwdLocal;
        } else if (choix == 2) {
            url = urlRemote;
            user = userRemote;
            password = pwdRemote;
        } else {
            System.out.println("Choix invalide, arrêt du programme.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion établie avec la base de données : " + (choix == 1 ? "Locale" : "Distante"));
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
