package main;

import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

//This class load the save Folder from a folder.
public class loadSavedGameFiles {

    File Folder = new File("C:\\Users\\PC\\Documents\\savedGames");
    File[] folderArray = Folder.listFiles();

    //Check it savedGame folder exist if not it creats it
    public void load(ListView<File> listView) {
        ObservableList list = FXCollections.observableArrayList();
        if (!Folder.exists()) {
            Folder.mkdir();
            System.out.println("File created");
        } else {
            for (File folders : folderArray) {
                list.add(folders);
            }
            listView.getItems().addAll(list);
            listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }

    public void loadSaveGame(String fileName) {
        File file = new File(fileName);
        File[] fileArray = file.listFiles();
        for (File files : fileArray) {
            System.out.println(files);
        }
    }

    public void saveGameFile(String savedGame) {
        csi.savedGame = savedGame;
    }
}
