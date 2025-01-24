package fr.esiee.easytrainfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjoutUtilisateurController {

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;

    @FXML
    private ComboBox<String> cbRole;

    @FXML
    private Label lblMessage;

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/easytrainfx";

    @FXML
    public void initialize() {
        cbRole.getItems().addAll("Admin", "Utilisateur", "Visiteur");
    }

    @FXML
    private void onResetButtonClick() {
        tfNom.clear();
        tfPrenom.clear();
        cbRole.getSelectionModel().clearSelection();
        lblMessage.setText("");
    }

    @FXML
    private void onAddButtonClick() {
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String role = cbRole.getValue();

        if (nom.isEmpty() || prenom.isEmpty() || role == null) {
            lblMessage.setText("Erreur : Tous les champs doivent être remplis.");
            lblMessage.setStyle("-fx-text-fill: red;");
        } else {
            if (addUserToDatabase(nom, prenom, role)) {
                lblMessage.setText("Utilisateur ajouté avec succès !");
                lblMessage.setStyle("-fx-text-fill: green;");
                tfNom.clear();
                tfPrenom.clear();
                cbRole.getSelectionModel().clearSelection();
            } else {
                lblMessage.setText("Erreur lors de l'ajout de l'utilisateur.");
                lblMessage.setStyle("-fx-text-fill: red;");
            }
        }
    }

    private boolean addUserToDatabase(String nom, String prenom, String role) {
        String sql = "INSERT INTO users (nom, prenom, role) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, role);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
