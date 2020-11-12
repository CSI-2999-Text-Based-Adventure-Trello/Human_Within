package main;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CSI2999Project extends Application {

    final protected String gameNames = "Human Within";
    public static String savedGame = null;
    public static ArrayList<String> fileList = new ArrayList<String>();
    public static ArrayList<Decision> decisionList = new ArrayList();
    public static int numberOfDescision = 0;
    public static String question;
    public static String storyText; //added storyText variable
    public static int newGame;
    public static String fileLocation = "C:\\savedGames";
    public static String player;

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
