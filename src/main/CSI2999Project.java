package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CSI2999Project extends Application {
    
    final protected String gameNames = "Human Within";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/startMenu/startMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(gameNames);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
