package UI;

import main.loadSavedGameFiles;
import main.newGameFiles;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.CSI2999Project;

public class saveMenuController implements Initializable {

    //Use for the ListView
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listViewBeta;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Button newGame;
    startMenuController sTMC = new startMenuController();
    loadSavedGameFiles load = new loadSavedGameFiles();
    newGameFiles nGF = new newGameFiles();

    //This will load the selected save game
    @FXML
    private void loadGameButtonAction(ActionEvent event) {
        //This get the save game the user selected then close the saveMenu.fxml
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            CSI2999Project.savedGame = (CSI2999Project.fileLocation + "\\"
                    + listViewBeta.getSelectionModel().getSelectedItem());
            System.out.println(CSI2999Project.savedGame);
            thisStage.close();
        } catch (Exception e) {
            System.out.println("ERROR!!");
        }
    }

    @FXML
    private void newGameButtonAction(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (!(nameTextField.getText().isEmpty())) {
            String tempString = CSI2999Project.fileLocation + "\\" + nameTextField.getText();
            CSI2999Project.player = nameTextField.getText();
            File temp = new File(tempString);
            nGF.createFileName(temp);
            CSI2999Project.savedGame = tempString;
            thisStage.close();
        } else {
            nameLabel.setVisible(true);
            nameTextField.setVisible(true);
            newGame.setText("Continue");
        }
    }

    //Thie with Exit out of the Save Nenu
    @FXML
    private void cancelButtonAction(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load.load(listViewBeta);
    }
}
