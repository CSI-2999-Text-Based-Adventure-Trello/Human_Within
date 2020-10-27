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
    private Button choiceE;
    @FXML
     TextArea textArea;
    switchBetweenScenes sBS = new switchBetweenScenes();
    Decision dec = new Decision();
     
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
    private void choiceA(ActionEvent event) {
        String textFileQ, textFileA;
        //Add Q.txt or A.txt to open 0001Q.txt & 0001A.txt
        textFileQ = CSI2999Project.decisionList.get(0).getTextfile() + "Q.txt";
        textFileA = CSI2999Project.decisionList.get(0).getTextfile() + "A.txt";
        dec.decisionQuestion(textFileQ);
        textArea.setText(CSI2999Project.question);
        dec.decisionAnswers(textFileA);
        labelButtons();
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
                case 4:
                    choiceE.setText(CSI2999Project.decisionList.get(i).getAnswer());
                    choiceE.setVisible(true);
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
                case 4:
                    choiceE.setVisible(false);
                    break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String textFileQ = "0001Q.txt";
        String textFileA = "0001A.txt";
        dec.decisionQuestion(textFileQ);
        textArea.setText(CSI2999Project.question);
        dec.decisionAnswers(textFileA);
        labelButtons();
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
