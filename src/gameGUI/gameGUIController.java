package gameGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import main.switchBetweenScenes;

public class gameGUIController implements Initializable {
    
    switchBetweenScenes sBS = new switchBetweenScenes();
    
    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        sBS.switchScence("/startMenu/startMenu.fxml", thisStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
