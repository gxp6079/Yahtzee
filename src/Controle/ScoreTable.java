package Controle;

import java.util.HashMap;

public class ScoreTable {

    Player player;
    HashMap<String, Integer> scores;

    public ScoreTable(Player player){
        this.player = player;
        this.scores = new HashMap<>();
        scores.put("Ones", 0);
        scores.put("Two", 0);
        scores.put("Three", 0);
        scores.put("Fours", 0);
        scores.put("Fives", 0);
        scores.put("Sixes", 0);
        scores.put("FullHouse", 0);
        scores.put("FourOfAKind", 0);
        scores.put("Straight", 0);
        scores.put("YAHTZEE", 0);
    }

    public void addScore(String type, int value) throws Exception {
        if (checkValid(type, value)) {
            scores.replace(type, value);
        }
        else{
            /*
            create an exception
             */
            throw new Exception();
        }
    }

    public boolean checkValid(String type, int value){
        return player.getDices().getScoreOptions().get(type) == value;
    }

}
