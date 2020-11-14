package UI;

import main.loadSavedGameFiles;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import main.CSI2999Project;
import main.switchBetweenScenes;

public class startMenuController implements Initializable {

    switchBetweenScenes sBS = new switchBetweenScenes();
    loadSavedGameFiles load = new loadSavedGameFiles();

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        CSI2999Project.newGame = true;
        CSI2999Project.hideText = true;
        sBS.newScence("/UI/saveMenu.fxml");
        try {
            if (!(CSI2999Project.savedGame == null)) {
                load.loadSaveGame(CSI2999Project.savedGame);
                sBS.switchScence("/UI/gameGUI.fxml", thisStage);
            } else {
                System.out.println("ERROR!");
            }
        } catch (IOException e) {            
            System.out.println("ERROR!");
        }
    }

    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/gameGUI.fxml", thisStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
