package main;

import java.nio.file.Paths;

public class storyDesisonManagement {

    switchBetweenScenes sBS = new switchBetweenScenes();
    Decision dec = new Decision();
    String location = "./src/Story/", question = "Q.txt", answer = "A.txt";

    //This method is use for nonstarter 
    //when the decisionList has the picked in it
    public void fileManagement(int picked) {
        Paths.get(".");
        String textFileQ, textFileA, textFileST;
        //Add Q.txt or A.txt to open 0001Q.txt & 0001A.txt
        textFileQ = location + CSI2999Project.decisionList.get(picked).getTextfile().trim() + question;
        dec.decisionQuestion(textFileQ);
        textFileA = location + CSI2999Project.decisionList.get(picked).getTextfile().trim() + answer;
        dec.decisionAnswers(textFileA);
    }

    //This is used when the decisionList is clear
    //Used in starting new game or loading game back
    public void fileManagement(String start) {
        String textFileQ, textFileA;
        //Add Q.txt or A.txt to open 0001Q.txt & 0001A.txt
        textFileQ = location + start + question;
        dec.decisionQuestion(textFileQ);
        textFileA = location + start + answer;
        dec.decisionAnswers(textFileA);
    }
}
