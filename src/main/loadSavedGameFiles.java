package main;

import java.io.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

//This class load the save Folder from a folder.
public class loadSavedGameFiles {

    File Folder = new File(CSI2999Project.fileLocation);
    File[] folderArray = Folder.listFiles();

    //Check it savedGame folder exist if not it creats it
    public void load(ListView<String> listView) {
        ObservableList list = FXCollections.observableArrayList();
        if (!Folder.exists()) {
            Folder.mkdir();
        } else {
            for (File folders : folderArray) {
                list.add(folders.getName());
            }
            listView.getItems().addAll(list);
        }
    }

    //load different files from users save game
    public void loadSaveGame(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        saveGame(fileName + "\\saveGame.txt");
        //inventory(fileName + "\\Inventory.txt"); //Not being used right now
        
    }

    //Put the save game into an array
    public void saveGame(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String fileList;
            while ((fileList = reader.readLine()) != null) {
                CSI2999Project.fileList.add(fileList);
            }
        } catch (IOException e) {
        }
    }

    //Put the inventory into an array //Not being used right now
    public void inventory(String fileName) {
        File file = new File(fileName + "\\Inventory.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String fileList;
            while ((fileList = reader.readLine()) != null) {
                //CSI2999Project.inventory.add(fileList);
            }
        } catch (IOException e) {
        }
    }
}
