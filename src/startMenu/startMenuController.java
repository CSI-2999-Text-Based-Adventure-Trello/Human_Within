package startMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import main.CSI2999Project;
import loadGame.loadSavedGameFiles;
import main.switchBetweenScenes;

public class startMenuController implements Initializable {

    switchBetweenScenes sBS = new switchBetweenScenes();
    loadSavedGameFiles load = new loadSavedGameFiles();

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        CSI2999Project.newGame = 1;
        sBS.newScence("/saveMenu/saveMenu.fxml");
        try {
            load.loadSaveGame(CSI2999Project.savedGame);
            sBS.switchScence("/gameGUI/gameGUI.fxml", thisStage);
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }

    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/gameGUI/gameGUI.fxml", thisStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
