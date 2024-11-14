package fr.esiee.dao;
import fr.esiee.model.Trajet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TrajetDAO {

    // Méthode pour ajouter un trajet
    public boolean ajouterTrajet(Trajet trajet) {
        String sql = "INSERT INTO trajets (code, tempsDepart, tempsArrivee) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, trajet.getCode());
            stmt.setTimestamp(2, Timestamp.valueOf(trajet.getTempsDepart()));
            stmt.setTimestamp(3, Timestamp.valueOf(trajet.getTempsArrivee()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;  // Retourne true si l'insertion est réussie
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Méthode pour supprimer un trajet
    public boolean supprimerTrajet(String code) {
        String sql = "DELETE FROM trajets WHERE code = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, code);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;  // Retourne true si la suppression est réussie
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Méthode pour récupérer tous les trajets
    public List<Trajet> getAllTrajets() {
        List<Trajet> trajets = new ArrayList<>();
        String sql = "SELECT * FROM trajets";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Trajet trajet = new Trajet(
                        rs.getString("code"),                             // Récupère le code du trajet
                        rs.getTimestamp("tempsDepart").toLocalDateTime(), // Convertit Timestamp en LocalDateTime
                        rs.getTimestamp("tempsArrivee").toLocalDateTime() // Convertit Timestamp en LocalDateTime
                );
                trajets.add(trajet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trajets;
    }

    // Méthode pour obtenir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        // Implémentez la logique de connexion à votre base de données ici
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
    }
}
