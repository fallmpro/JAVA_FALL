package fr.esiee.easytrainfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EasyTrainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajoutUtilisateur-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        primaryStage.setTitle("Ajouter un Utilisateur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
