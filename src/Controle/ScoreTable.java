package Controle;

import java.util.HashMap;

public class ScoreTable {

    private Player player1;
    private Player player2;
    private HashMap<String, String> player1Score;
    private HashMap<String, String> player2Score;

    public ScoreTable(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        player1Score.put("One", "0");
        player2Score.put("One", "0");
        player1Score.put("Two", "0");
        player2Score.put("Two", "0");
        player1Score.put("Three", "0");
        player2Score.put("Three", "0");
        player1Score.put("Four", "0");
        player2Score.put("Four", "0");
        player1Score.put("Five", "0");
        player2Score.put("Five", "0");
        player1Score.put("Six", "0");
        player2Score.put("Six", "0");
        player1Score.put("Full House", "0");
        player2Score.put("Full House", "0");
        player1Score.put("4 of a Kind", "0");
        player2Score.put("4 of a Kind", "0");
        player1Score.put("Straight", "0");
        player2Score.put("Straight", "0");
        player1Score.put("YAHTZEE", "0");
        player2Score.put("YAHTZEE", "0");
    }

    public void addScore(Player player, String type, String value){
        if(player.equals(player1)){
            player1Score.replace(type, value);
        } else if(player.equals(player2)){
            player2Score.replace(type, value);
        }
    }

}
