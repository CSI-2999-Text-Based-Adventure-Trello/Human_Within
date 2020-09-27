package startMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import saveMenu.saveMenuController;
import main.switchBetweenScenes;

public class startMenuController implements Initializable {

    switchBetweenScenes sBS = new switchBetweenScenes();
    saveMenuController sMC = new saveMenuController();

    @FXML
    private void startButtonAction(ActionEvent event) throws IOException {
        String savedGame = null;
        sBS.newScence("/saveMenu/saveMenu.fxml");
        String saveGame = sMC.saveGame;
        System.out.println(sMC.saveGame);
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
