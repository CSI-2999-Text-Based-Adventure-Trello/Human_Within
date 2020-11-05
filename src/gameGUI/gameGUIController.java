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
import DecisionMaker.Decision;
import main.CSI2999Project;
import Story.storyDesisonManagement;

public class gameGUIController implements Initializable {

    @FXML
    private Button btnEnd;
    @FXML
    private Button choiceA;
    @FXML
    private Button choiceB;
    @FXML
    private Button choiceC;
    @FXML
    private Button choiceD;
    @FXML
    TextArea txtOutput;
    switchBetweenScenes sBS = new switchBetweenScenes();
    Decision dec = new Decision();
    storyDesisonManagement sDM = new storyDesisonManagement();

//     @FXML
//     private Button btnVictory1;
//     @FXML
//     private Button btnA;
//     @FXML
//     private Button btnB;
//     @FXML
//     private TextArea txtOutput;
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
    
    @FXML
     private void contButtonAction(ActionEvent event) throws IOException {
        
        txtOutput.setText(CSI2999Project.question);
        String textFileQ;
        textFileQ = "./src//Story/" + CSI2999Project.question;
        dec.decisionQuestion(textFileQ);
        labelButtons();
    }

    @FXML
    private void hideButtons(){         // hide buttons when story text shown
        choiceA.setVisible(false);
        choiceB.setVisible(false);
        choiceC.setVisible(false);
        choiceD.setVisible(false);
    } 
    
    @FXML
    private void choiceA(ActionEvent event) {
        sDM.fileManagement(0);
        txtOutput.setText(CSI2999Project.storyText);
        hideButtons();

    }

    @FXML
    private void choiceB(ActionEvent event) {
        sDM.fileManagement(1);
        txtOutput.setText(CSI2999Project.storyText);
        hideButtons();

    }

    @FXML
    private void choiceC(ActionEvent event) {
        sDM.fileManagement(2);
        txtOutput.setText(CSI2999Project.storyText);
        hideButtons();

    }

    @FXML
    private void choiceD(ActionEvent event) {
        sDM.fileManagement(3);
        txtOutput.setText(CSI2999Project.storyText);
        hideButtons();
    }

    public void labelButtons() {
        //Set set Text to the decision and set them visible
        for (int i = 0; i < CSI2999Project.numberOfDescision; i++) {
            switch (i) {
                case 0:
                    choiceA.setText(CSI2999Project.decisionList.get(i).getAnswer());
                    choiceA.setVisible(true);
                    break;
                case 1:
                    choiceB.setText(CSI2999Project.decisionList.get(i).getAnswer());
                    choiceB.setVisible(true);
                    break;
                case 2:
                    choiceC.setText(CSI2999Project.decisionList.get(i).getAnswer());
                    choiceC.setVisible(true);
                    break;
                case 3:
                    choiceD.setText(CSI2999Project.decisionList.get(i).getAnswer());
                    choiceD.setVisible(true);
                    break;
            }
        }
        //Set any other choice to invisible if not being used
        for (int i = CSI2999Project.numberOfDescision; i < 5; i++) {
            switch (i) {
                case 0:
                    choiceA.setVisible(false);
                    break;
                case 1:
                    choiceB.setVisible(false);
                    break;
                case 2:
                    choiceC.setVisible(false);
                    break;
                case 3:
                    choiceD.setVisible(false);
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (CSI2999Project.newGame == 1) {
            sDM.fileManagement("0001");
            txtOutput.setText(CSI2999Project.storyText);
            CSI2999Project.newGame = 0;
        }
        hideButtons();

    }

    @FXML
    private void handleEndButton1(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/endScreen/endScreen2.fxml", thisStage);
    }

//     @FXML
//     private void handleChoiceA(ActionEvent event) {
//         txtOutput.setText("Select Choice B to win");
//     }
//     @FXML
//     private void handleChoiceB(ActionEvent event) {
//         Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         sBS.switchScence("/endScreen/endScreen2.fxml", thisStage);
//     }
}
