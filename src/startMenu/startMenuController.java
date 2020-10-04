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
import main.switchBetweenScenes;

public class startMenuController implements Initializable {

    CSI2999Project csi = new CSI2999Project();
    switchBetweenScenes sBS = new switchBetweenScenes();

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        sBS.newScence("/saveMenu/saveMenu.fxml");
    }

    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/gameGUI/gameGUI.fxml", thisStage);
    }

    public void saveGameFile(String savedGame) {
        csi.savedGame = savedGame;
        System.out.println(csi.savedGame);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
