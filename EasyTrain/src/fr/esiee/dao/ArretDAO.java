package fr.esiee.dao;
import fr.esiee.model.Arret;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArretDAO {

    String userLocal = "root";
    String pwdLocal = "";
    String urlLocal = "jdbc:mariadb://localhost:3306/easytrain";

    // Ajouter un nouvel arrêt
    public void addArret(Arret arret) {
        String sql = "INSERT INTO Arret (nom) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(userLocal, pwdLocal, urlLocal);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, arret.getNom());
            statement.executeUpdate();
            System.out.println("Arrêt ajouté avec succès.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer un arrêt par ID
    public Arret getArretById(int id) {
        String sql = "SELECT * FROM Arret WHERE id = ?";
        Arret arret = null;

        try (Connection connection = DriverManager.getConnection(userLocal, pwdLocal, urlLocal);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                arret = new Arret(id, nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arret;
    }

    // Supprimer un arrêt par ID
    public void deleteArret(int id) {
        String sql = "DELETE FROM Arret WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(userLocal, pwdLocal, urlLocal);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Arrêt supprimé avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Récupérer tous les arrêts
    public List<Arret> getAllArrets() {
        String sql = "SELECT * FROM Arret";
        List<Arret> arrets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(userLocal, pwdLocal, urlLocal);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                arrets.add(new Arret(id, nom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrets;
    }
}