package UI;

import main.loadSavedGameFiles;
import main.saveGame;
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
import main.Decision;
import main.CSI2999Project;
import main.storyDesisonManagement;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private TextArea txtOutput;
    private int number;
    private Stage event;

    switchBetweenScenes sBS = new switchBetweenScenes();
    Decision dec = new Decision();
    storyDesisonManagement sDM = new storyDesisonManagement();
    loadSavedGameFiles lSGF = new loadSavedGameFiles();
    saveGame sG = new saveGame();

    @FXML
    private void tempButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/startMenu.fxml", thisStage);
    }

    @FXML
    private void handleEndButton(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/UI/endScreen.fxml", thisStage);
    }

    @FXML
    private void contButtonAction(ActionEvent event) throws IOException {
        try {
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            switch (CSI2999Project.decisionList.get(number).getEndGame()) {
                case "false":
                case "False":
                    sDM.fileManagement(number);
                    txtOutput.setText(CSI2999Project.storyText);
                    sG.saveGameFile(CSI2999Project.decisionList.get(number).getTextfile().trim());
                    labelButtons();
                    txtOutput.setText(txtOutput.getText() + "\n" + CSI2999Project.question);
                    String textFileQ;
                    textFileQ = "./src//Story/" + CSI2999Project.question;
                    dec.decisionQuestion(textFileQ);
                    CSI2999Project.hideButtons = false;
                    break;
                case "bad":
                case "Bad":
                    clear();
                    sBS.switchScence("/UI/endScreen.fxml", thisStage);
                    break;
                case "good":
                case "Good":
                    clear();
                    sBS.switchScence("/UI/endScreen2.fxml", thisStage);
                default:
                    System.out.println("HOW DID YOU GET HERE, LIKE HOW????");
                    break;
            }
        } catch (Exception e) {
        }
    }

    private void clear() {
        CSI2999Project.savedGame = null;
        CSI2999Project.decisionList.clear();
        CSI2999Project.numberOfDescision = 0;
        CSI2999Project.question = null;
        CSI2999Project.storyText = null;
        CSI2999Project.player = null;
    }

    @FXML
    private void choiceA(ActionEvent event) {
        number = 0;
        hideButtons();
    }

    @FXML
    private void choiceB(ActionEvent event) {
        number = 1;
        hideButtons();
    }

    @FXML
    private void choiceC(ActionEvent event) {
        number = 2;
        hideButtons();
    }

    @FXML
    private void choiceD(ActionEvent event) {
        number = 3;
        hideButtons();
    }

    @FXML
    private void hideButtons() {         // hide buttons when story text shown
        choiceA.setVisible(false);
        choiceB.setVisible(false);
        choiceC.setVisible(false);
        choiceD.setVisible(false);
        CSI2999Project.hideButtons = true;
    }

    @FXML
    private void handleEndButton1(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sBS.switchScence("/endScreen/endScreen2.fxml", thisStage);
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
        for (int i = CSI2999Project.numberOfDescision; i <= 3; i++) {
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
        if (CSI2999Project.newGame == true) {
            //Open savedGame and then read saveGame.txt file
            String tempString = CSI2999Project.fileLocation + "\\" + CSI2999Project.player + "\\saveGame.txt";
            File file = new File(tempString);
            try {
                lSGF.loadSaveGame(CSI2999Project.fileLocation);
            } catch (IOException ex) {
                Logger.getLogger(gameGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
            sDM.fileManagement(CSI2999Project.fileList.get(CSI2999Project.fileList.size() - 1));
            CSI2999Project.newGame = false;
        }
        if (CSI2999Project.hideButtons == true) {
            hideButtons();
            txtOutput.setText(CSI2999Project.storyText);
        } else {
            labelButtons();
            txtOutput.setText(CSI2999Project.question);
        }
    }
}
