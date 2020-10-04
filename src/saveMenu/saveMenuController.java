package saveMenu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import main.loadSavedGameFiles;
import startMenu.startMenuController;

public class saveMenuController implements Initializable {

    //Use for the ListView
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ListView<File> listView;
    startMenuController sTMC = new startMenuController();
    loadSavedGameFiles load = new loadSavedGameFiles();

    //This will load the selected save game
    @FXML
    private void loadGameButtonAction(ActionEvent event) {
        //This get the save game the user selected then close the saveMenu.fxml
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sTMC.saveGameFile(listView.getSelectionModel().getSelectedItem().toString());
        thisStage.close();
    }

    //Thie with Exit out of the Save Nenu
    @FXML
    private void cancelButtonAction(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load.load(listView);
    }
}
