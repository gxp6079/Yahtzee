package Controle;

import java.util.HashMap;

public class DiceTable {

    private HashMap<String , Dice> dices;

    public DiceTable(){
        dices = new HashMap<>();
        for (int i = 1 ; i < 6 ; i++){
            String name = "Dice " + Integer.toString(i);
            dices.put(name, new Dice(name));
        }
        for (Dice dice : dices.values()){
            dice.roll();
        }
    }

    public HashMap<String, Integer> getScoreOptions() {
        ScoreOptions scoreOptions = new ScoreOptions(dices.values());
        return scoreOptions.getOptions();
    }

    public HashMap<String, Dice> getDices() {
        return dices;
    }

    public void roll(){
        for (Dice dice : dices.values()){
            if (dice.getSelection()){
                dice.roll();
            }
        }
    }
}
