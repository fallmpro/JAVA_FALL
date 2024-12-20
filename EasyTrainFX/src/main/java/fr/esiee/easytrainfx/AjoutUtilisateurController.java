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

    /**
     * Action pour le bouton Réinitialiser.
     */
    @FXML
    private void onResetButtonClick() {
        tfNom.clear();
        tfPrenom.clear();
        cbRole.getSelectionModel().clearSelection();
        lblMessage.setText("");
    }

    /**
     * Action pour le bouton Ajouter.
     */
    @FXML
    private void onAddButtonClick() {
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String role = cbRole.getValue();

        if (nom.isEmpty() || prenom.isEmpty() || role == null) {
            lblMessage.setText("Erreur : Tous les champs doivent être remplis.");
            lblMessage.setStyle("-fx-text-fill: red;");
        } else {
            // Ajoutez ici la logique pour sauvegarder l'utilisateur.
            lblMessage.setText("Utilisateur ajouté avec succès !");
            lblMessage.setStyle("-fx-text-fill: green;");
        }
    }
}
