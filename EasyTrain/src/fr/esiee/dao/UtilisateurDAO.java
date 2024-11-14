package fr.esiee.dao;
import fr.esiee.model.Utilisateur;
import org.mariadb.jdbc.client.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class UtilisateurDAO {
    String userLocal = "root";
    String pwdLocal = "";
    String urlLocal = "jdbc:mariadb://localhost:3306/easytrain";

    //Ajouter un nouvel Utilisateur
    public void addUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO Utilisateur (login) VALUES (?)";
        try (Connection connection = getConnection(userLocal, pwdLocal, urlLocal);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, utilisateur.getLogin());
            statement.executeUpdate();
            System.out.println("User ajouté avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Supprimer un user par son id
    public void deleteUtilisateur(Utilisateur utilisateur){
    String sql = "DELETE FROM Utilisateur WHERE login = ?";
        try (Connection connection = getConnection(userLocal, pwdLocal, urlLocal);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, utilisateur.getLogin());
            statement.executeUpdate();
            System.out.println("User supprimé avec succès !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Recuperer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateur() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        rs.getInt("id"), // Récupère l'id
                        rs.getString("prenom"),// Récupère le prénom
                        rs.getString("nom"), // Récupère le nom
                        rs.getString("login"),// Récupère le login
                        rs.getString("mdp"),// Récupère le mot de passe
                        rs.getDate("dateEmbauche").toLocalDate(), // Convertit la date en LocalDate
                );
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
}



