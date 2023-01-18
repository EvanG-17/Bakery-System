package main;

// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

// SDK being used for JavaFX is for Apple Silicon, switch to different architecture SDK if needed.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class fxmlApplication extends Application {

    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/baker_welcome_screen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
