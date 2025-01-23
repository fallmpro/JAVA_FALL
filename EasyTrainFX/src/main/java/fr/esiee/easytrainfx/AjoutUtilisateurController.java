package fr.esiee.easytrainfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AjoutUtilisateurController {

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;

    @FXML
    private ComboBox<String> cbRole;

    @FXML
    private Label lblMessage;

    @FXML
    public void initialize() {
        // Ajouter les rôles à la ComboBox
        cbRole.getItems().addAll("Admin", "Utilisateur", "Visiteur");
    }

    @FXML
    private void onResetButtonClick() {
        // Réinitialiser les champs
        tfNom.clear();
        tfPrenom.clear();
        cbRole.getSelectionModel().clearSelection();
        lblMessage.setText("");
    }

    @FXML
    private void onAddButtonClick() {
        // Récupérer les données
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String role = cbRole.getValue();

        // Valider les champs
        if (nom.isEmpty() || prenom.isEmpty() || role == null) {
            lblMessage.setText("Erreur : Tous les champs doivent être remplis.");
            lblMessage.setStyle("-fx-text-fill: #ff0000;");
        } else {
            // Message de succès
            lblMessage.setText("Utilisateur ajouté avec succès :\nNom : " + nom + ", Prénom : " + prenom + ", Rôle : " + role);
            lblMessage.setStyle("-fx-text-fill: green;");

            // Réinitialiser après ajout
            tfNom.clear();
            tfPrenom.clear();
            cbRole.getSelectionModel().clearSelection();
        }
    }
}
