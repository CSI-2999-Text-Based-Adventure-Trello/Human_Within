package DecisionMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import main.CSI2999Project;
import static main.CSI2999Project.decisionList;

public class Decision {

    private String textfile;
    private String Answer;

    public Decision(String textfile, String Answer) {
        this.textfile = textfile;
        this.Answer = Answer;
    }

    public Decision() {

    }

    public String getTextfile() {
        return textfile;
    }

    public String getAnswer() {
        return Answer;
    }

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
                count++;
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public void decisionAnswers(String TextFileA) {
        CSI2999Project.decisionList.clear();
        try (Scanner fileIn = new Scanner(new File(TextFileA))) {
            String textfile, Answer;
            while (fileIn.hasNext()) {
                textfile = fileIn.nextLine();
                Answer = fileIn.nextLine();
                Decision temp = new Decision(textfile, Answer);
                decisionList.add(temp);
            }
        } catch (FileNotFoundException ex) {
        }
    }
}
