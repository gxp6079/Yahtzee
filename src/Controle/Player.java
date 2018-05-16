package Controle;

public class Player {

    private String name;
    private DiceTable dices;

    public Player(String name){
        this.name = name;
        this.dices = new DiceTable();
    }

    public DiceTable getDices() {
        return dices;
    }

    public Pair chooseScore(String scoreType, int value){
        return new Pair(scoreType, value);
    }

    public void play(){
        dices.getScoreOptions().start();
        dices.rollAll();
    }

    public void rollSelected(){
        dices.roll();
    }

    public void selectScore() throws Exception{
        String selected = dices.getScoreOptions().getSelected();
    }

    public String getName() {
        return name;
    }
}
