package fr.esiee.easytrainfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjoutArretController {

    @FXML
    private TextField tfNomArret;

    @FXML
    private TextField tfEmplacement;

    @FXML
    private ComboBox<String> cbTypeArret;

    @FXML
    private Label lblMessage;

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/easytrainfx";

    @FXML
    public void initialize() {
        // Ajout des types d'arrêt dans la ComboBox
        cbTypeArret.getItems().addAll("Terminus", "Station", "Aire de repos", "Autre");
    }

    @FXML
    private void onResetButtonClick() {
        tfNomArret.clear();
        tfEmplacement.clear();
        cbTypeArret.getSelectionModel().clearSelection();
        lblMessage.setText("");
    }

    @FXML
    private void onAddButtonClick() {
        String nomArret = tfNomArret.getText();
        String emplacement = tfEmplacement.getText();
        String typeArret = cbTypeArret.getValue();

        // Validation des champs
        if (nomArret.isEmpty() || emplacement.isEmpty() || typeArret == null) {
            lblMessage.setText("Erreur : Tous les champs doivent être remplis.");
            lblMessage.setStyle("-fx-text-fill: red;");
        } else {
            // Ajout de l'arrêt à la base de données
            if (addArretToDatabase(nomArret, emplacement, typeArret)) {
                lblMessage.setText("Arrêt ajouté avec succès !");
                lblMessage.setStyle("-fx-text-fill: green;");
                tfNomArret.clear();
                tfEmplacement.clear();
                cbTypeArret.getSelectionModel().clearSelection();
            } else {
                lblMessage.setText("Erreur lors de l'ajout de l'arrêt.");
                lblMessage.setStyle("-fx-text-fill: red;");
            }
        }
    }

    private boolean addArretToDatabase(String nomArret, String emplacement, String typeArret) {
        String sql = "INSERT INTO arrets (nom_arret, emplacement, type_arret) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomArret);
            stmt.setString(2, emplacement);
            stmt.setString(3, typeArret);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
