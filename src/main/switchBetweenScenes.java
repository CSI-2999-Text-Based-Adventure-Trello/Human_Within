package main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class switchBetweenScenes {

    //Switches between scences keeps it in the same windows
    public void switchScence(String scence, Stage thisStage) {
        try {
            Parent gameGUILoader = FXMLLoader.load(getClass().getResource(scence));
            Scene gameGUI = new Scene(gameGUILoader);
            thisStage.setScene(gameGUI);
            thisStage.show();
        } catch (IOException e) {
        }
    }

    //Pop-Up new Window
    public void newScence(String scence) {
        try {
            FXMLLoader saveMenuLoader = new FXMLLoader(getClass().getResource(scence));
            Parent saveWindow = (Parent) saveMenuLoader.load();
            Stage saveStage = new Stage();
            saveStage.initModality(Modality.APPLICATION_MODAL);
            saveStage.setScene(new Scene(saveWindow));
            saveStage.setTitle("Pick your save game file");
            saveStage.showAndWait();
        } catch (IOException e) {
        }
    }
}
