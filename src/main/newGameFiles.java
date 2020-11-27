package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class newGameFiles {

    public void createFileName(File Folder) throws IOException {
        File fileName = Folder;
        if (!fileName.exists()) {
            fileName.mkdir();
            String tempString = Folder.toString() + "\\";
            saveGameTXT(tempString);
            InventoryTXT(tempString);
        }
    }

    public void saveGameTXT(String file) throws IOException {
        File fileLedger = new File(file + "saveGame.txt");
        FileWriter fw = new FileWriter(fileLedger);
        PrintWriter pw = new PrintWriter(fw);
        pw.print("0001");
        pw.close();
    }

    public void InventoryTXT(String file) throws IOException {
        File fileLedger = new File(file + "Inventory.txt");
        FileWriter fw = new FileWriter(fileLedger);
        PrintWriter pw = new PrintWriter(fw);
        pw.close();
    }
}
