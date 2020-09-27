package saveMenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class saveMenuController implements Initializable {

    //save game
    public String saveGame = null;
    //Use for the ListView
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ListView<String> listView;

    //This will load the selected save game
    @FXML
    private void loadGameButtonAction(ActionEvent event) {
        //This get the save game the user selected then close the saveMenu.fxml
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        saveGame = listView.getSelectionModel().getSelectedItem();
        System.out.println(saveGame);
        thisStage.close();
    }

    //Thie with Exit out of the Save Nenu
    @FXML
    private void cancelButtonAction(ActionEvent event) {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.close();
    }

    private void loadDate() {
        //This clear all the data in the List
        list.clear();
        String a = "Iron Man";
        String b = "Titanic";
        String c = "Contact";
        String d = "Surrogates";
        list.addAll(a, b, c, d);
        /*or This will add one by one
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
         */
        listView.getItems().addAll(list);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }
}
