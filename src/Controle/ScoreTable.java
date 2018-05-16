package Controle;

import java.util.HashMap;

public class ScoreTable {

    Player player1;
    Player player2;
    HashMap<String, Integer> scoresPlayer1;
    HashMap<String, Integer> scoresPlayer2;

    public ScoreTable(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.scoresPlayer1 = new HashMap<>();
        this.scoresPlayer2 = new HashMap<>();
        scoresPlayer1.put("Ones", 0);
        scoresPlayer1.put("Two", 0);
        scoresPlayer1.put("Three", 0);
        scoresPlayer1.put("Fours", 0);
        scoresPlayer1.put("Fives", 0);
        scoresPlayer1.put("Sixes", 0);
        scoresPlayer1.put("FullHouse", 0);
        scoresPlayer1.put("FourOfAKind", 0);
        scoresPlayer1.put("Straight", 0);
        scoresPlayer1.put("YAHTZEE", 0);
        scoresPlayer2.put("Ones", 0);
        scoresPlayer2.put("Two", 0);
        scoresPlayer2.put("Three", 0);
        scoresPlayer2.put("Fours", 0);
        scoresPlayer2.put("Fives", 0);
        scoresPlayer2.put("Sixes", 0);
        scoresPlayer2.put("FullHouse", 0);
        scoresPlayer2.put("FourOfAKind", 0);
        scoresPlayer2.put("Straight", 0);
        scoresPlayer2.put("YAHTZEE", 0);
    }

    public void addScore(String player, String type, int value) throws Exception {
        if (checkValid(player, type, value)) {
            if (player.equals(player1.getName())){
                scoresPlayer1.replace(type, value);
            }
            else if(player.equals(player2.getName())){
                scoresPlayer2.replace(type, value);
            }
        }
        else{
            /*
            create invalid score exception exception
             */
            throw new Exception();
        }
    }

    public boolean checkValid(String player, String type, int value) throws Exception{
        if(player.equals(player1.getName())) {
            return player1.getDices().getScoreOptions().get(type) == value;
        }
        else if(player.equals(player2.getName())){
            return player2.getDices().getScoreOptions().get(type) == value;
        }
        else {
            throw new Exception();
        }
    }

}
