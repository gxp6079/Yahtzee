package Controle;

public class Player {

    private String name;

    public Player(String name){
        this.name = name;
    }

    public Pair chooseScore(String scoreType, int value){
        return new Pair(scoreType, value);
    }

    public void play(DiceTable dices, ScoreOptions options){
        dices.rollAll();
        options.setOptions(dices);
    }

    public void rollSelected(DiceTable dices, ScoreOptions options){
        dices.roll();
        options.setOptions(dices);
    }

    public String getName() {
        return name;
    }
}
