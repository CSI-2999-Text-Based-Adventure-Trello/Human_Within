package loadGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import main.CSI2999Project;

public class saveGame {

    public void saveGameFile(String fileName) {
        Paths.get(".");
        String path = CSI2999Project.fileLocation + "\\" + CSI2999Project.player + "\\saveGame.txt";
        System.out.println(path);
        System.out.println(fileName);
        String text = "\n" + fileName;
        try {
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
    }
}
