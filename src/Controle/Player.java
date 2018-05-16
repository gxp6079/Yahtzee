package Controle;

import java.util.ArrayList;

public class Player {

    private String name;
    private DiceTable dices;
    private ScoreTable scoreTable;

    public Player(String name){
        this.name = name;
        this.dices = new DiceTable();
        this.scoreTable = new ScoreTable(this);
    }

    public DiceTable getDices() {
        return dices;
    }

    public Pair chooseScore(String scoreType, int value){
        return new Pair(scoreType, value);
    }
}
