/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endScreen;

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

/**
 * FXML Controller class
 *
 * @author David Djeljaj
 */
public class endScreenController implements Initializable {
    switchBetweenScenes sBS = new switchBetweenScenes();

    @FXML
    private Button btnSrtrOver;
    @FXML
    private Label lblGameOver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void handleStartOver(ActionEvent event) throws IOException {
         Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/startMenu/startMenu.fxml", thisStage);
        
        
    }

    @FXML
    private void handleStartOver1(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/startMenu/startMenu.fxml", thisStage);
    }
    
        
    
}
