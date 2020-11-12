package main;

import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

//This class load the save Folder from a folder.
public class loadSavedGameFiles {

    File Folder = new File(CSI2999Project.fileLocation);
    File[] folderArray = Folder.listFiles();

    //Check it savedGame folder exist if not it creats it
    public void load(ListView<File> listView) {
        ObservableList list = FXCollections.observableArrayList();
        if (!Folder.exists()) {
            Folder.mkdir();
            System.out.println("File created");
        } else {
            for (File folders : folderArray) {
                CSI2999Project.player = folders.getName();
                list.add(folders);
            }
            listView.getItems().addAll(list);
            listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }

    //load different files from users save game
    public void loadSaveGame(String fileName) throws FileNotFoundException, IOException {
        try {
            File file = new File(fileName);
            File[] fileArray = file.listFiles();
            for (File files : fileArray) {
                if (files.toString().contains("saveGame.txt")) {
                    BufferedReader reader = new BufferedReader(new FileReader(files.toString()));
                    String fileList;
                    while ((fileList = reader.readLine()) != null) {
                        CSI2999Project.fileList.add(fileList);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}