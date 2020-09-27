package main;

public class savedGame {
    private String character;

    savedGame(){
        
    }
    
    savedGame(String character){
        this.character = character;
    }
    
    public String getCharacor() {
        return character;
    }

    public void setCharacor(String character) {
        this.character = character;
    }
}
