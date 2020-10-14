package gameGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.switchBetweenScenes;

public class gameGUIController implements Initializable {

    @FXML
    private Button btnEnd;
    switchBetweenScenes sBS = new switchBetweenScenes();
    @FXML
    private Button btnVictory1;
    @FXML
    private Button btnA;
    @FXML
    private Button btnB;
    @FXML
    private TextArea txtOutput;
   

    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/startMenu/startMenu.fxml", thisStage);
    }

    @FXML
    private void handleEndButton(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/endScreen/endScreen.fxml", thisStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleEndButton1(ActionEvent event) {
          Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/endScreen/endScreen2.fxml", thisStage);
    }

    @FXML
    private void handleChoiceA(ActionEvent event) {
        txtOutput.setText("Select Choice B to win");
    }

    @FXML
    private void handleChoiceB(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/endScreen/endScreen2.fxml", thisStage);
    }
}
