package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static main.CSI2999Project.decisionList;

public class Decision {

    private String textfile;
    private String Answer;
    private String endGame;

    public Decision(String textfile, String Answer, String endGame) {
        this.textfile = textfile;
        this.Answer = Answer;
        this.endGame = endGame;
    }

    public Decision() {

    }

    public String getTextfile() {
        return textfile;
    }

    public String getAnswer() {
        return Answer;
    }

    public String getEndGame() {
        return endGame;
    }

    //Number of Descision and Question load from file
    public void decisionQuestion(String TextFileQ) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(TextFileQ));
            String f;
            int count = 1;
            while ((f = reader.readLine()) != null) {
                if (count == 1) {
                    CSI2999Project.numberOfDescision = Integer.parseInt(f);
                }
                if (count == 2) {
                    CSI2999Project.question = f;
                }
                if (count == 3) {
                    if (!(f.equals(CSI2999Project.question))) {
                        CSI2999Project.storyText = f;
                    } else {
                        CSI2999Project.storyText = "Missing the Story Text!";
                    }
                }
                if (count == 4) {
                    if (!(f.equals(CSI2999Project.storyText))) {
                        CSI2999Project.talker = f + ".png";
                    } else {
                        CSI2999Project.talker = "missing1" + ".png";
                    }
                }
                count++;
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    //Clear decisionList then add new file to decisionList
    public void decisionAnswers(String TextFileA) {
        CSI2999Project.decisionList.clear();
        try (Scanner fileIn = new Scanner(new File(TextFileA))) {
            String textfile, Answer, endGame;
            while (fileIn.hasNext()) {
                textfile = fileIn.nextLine();
                Answer = fileIn.nextLine();
                endGame = fileIn.nextLine();
                Decision temp = new Decision(textfile, Answer, endGame);
                decisionList.add(temp);
            }
        } catch (FileNotFoundException ex) {
        }
    }
}
