/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.loadSavedGameFiles;
import main.switchBetweenScenes;

/**
 * FXML Controller class
 *
 * @author Owner
 */
public class InfoScreenController implements Initializable {
    
    switchBetweenScenes sBS = new switchBetweenScenes();
    loadSavedGameFiles load = new loadSavedGameFiles();

    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/startMenu.fxml", thisStage);
    }
    
}
