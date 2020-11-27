package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.switchBetweenScenes;

public class endScreenController implements Initializable {

    switchBetweenScenes sBS = new switchBetweenScenes();

    @FXML
    private Button btnSrtrOver;
    @FXML
    private Label lblGameOver;

    @FXML
    private void handleStartOver(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/startMenu.fxml", thisStage);

    }

    @FXML
    private void handleStartOver1(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/startMenu.fxml", thisStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
