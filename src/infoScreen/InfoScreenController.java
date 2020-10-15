/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infoScreen;

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

/**
 * FXML Controller class
 *
 * @author yariq
 */
public class InfoScreenController implements Initializable {
switchBetweenScenes sBS = new switchBetweenScenes();
    /**
     * Initializes the controller class.
     */
@FXML
private Button infobtn;
@FXML
private TextArea infotxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
      private void handleBack(ActionEvent event) throws IOException {
         Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/startMenu/startMenu.fxml", thisStage);
      }
}
