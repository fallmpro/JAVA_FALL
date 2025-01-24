package fr.esiee.easytrainfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EasyTrainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charge la vue pour l'ajout d'un arrêt
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutArret-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);  // Modifie les dimensions de la fenêtre si nécessaire
        primaryStage.setTitle("Ajouter un Arrêt");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
