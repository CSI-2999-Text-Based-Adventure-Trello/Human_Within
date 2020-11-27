package UI;

import main.loadSavedGameFiles;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.CSI2999Project;
import main.switchBetweenScenes;

public class startMenuController implements Initializable {

    switchBetweenScenes sBS = new switchBetweenScenes();
    loadSavedGameFiles load = new loadSavedGameFiles();
    @FXML
    private Button infoButton;

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        CSI2999Project.newGame = true;
        CSI2999Project.hideButtons = true;
        sBS.newScence("/UI/saveMenu.fxml");
        try {
            load.loadSaveGame(CSI2999Project.savedGame);
            if (CSI2999Project.savedGame != null) {
                //Open savedGame and then read saveGame.txt file
                sBS.switchScence("/UI/gameGUI.fxml", thisStage);
            }
        } catch (IOException e) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void infoButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/infoScreen.fxml", thisStage);
    }
}
