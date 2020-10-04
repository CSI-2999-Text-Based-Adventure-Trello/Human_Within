package main;

import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

//This class load the save file from a folder.
public class loadSavedGameFiles {

    File file = new File("C:\\Users\\PC\\Documents\\savedGames");

    File[] fileArray = file.listFiles();

    //Check it savedGame folder exist if not it creats it
    public void load(ListView<File> listView) {
        ObservableList list = FXCollections.observableArrayList();
        if (!file.exists()) {
            file.mkdir();
            System.out.println("File created");
        } else {
            for (File f : fileArray) {
                list.add(f);
            }
            listView.getItems().addAll(list);
            listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }
}
