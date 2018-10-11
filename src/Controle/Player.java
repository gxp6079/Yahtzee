package Controle;

public class Player {

    private String name;
    private DiceTable dices;
    private ScoreOptions options;

    public Player(String name){
        this.name = name;
        this.dices = new DiceTable();
        this.options = new ScoreOptions(dices);
    }

    public DiceTable getDices() {
        return dices;
    }

    public Pair chooseScore(String scoreType, int value){
        return new Pair(scoreType, value);
    }

    public void play(){
        options.start();
        dices.rollAll();
    }

    public ScoreOptions getOptions(){return options;}

    public void rollSelected(){
        dices.roll();
    }

    public void selectScore() throws Exception{
        String selected = options.getSelected();
    }

    public String getName() {
        return name;
    }
}
