package Controle;

import java.util.HashMap;

public class ScoreOptions {

    private HashMap<String, Option> options;
    private HashMap<Dice, Integer> occurrences;

    public ScoreOptions(DiceTable dices){
        this.options = new HashMap<>();
        this.occurrences = new HashMap<>();
        options.put("One", new Option("One"));
        options.put("Two", new Option("Two"));
        options.put("Three", new Option("Three"));
        options.put("Four", new Option("Four"));
        options.put("Five", new Option("Five"));
        options.put("Six", new Option("Six"));
        options.put("Full House", new Option("Full House"));
        options.put("4 of a Kind", new Option("4 of a Kind"));
        options.put("Straight", new Option("Straight"));
        options.put("YAHTZEE", new Option("YAHTZEE"));
        setOptions(dices);
    }

    public void setOptions(DiceTable dices){
        for(Dice dice : dices.getDices().values()){
            if(occurrences.containsKey(dice)){
                occurrences.replace(dice, occurrences.get(dice) + 1);
            }else {
                occurrences.put(dice, 1);
            }
        }
        for(Dice dice : occurrences.keySet()){
            options.get(dice.getName()).setValue(Integer.toString(occurrences.get(dice)));
        }
        options.get("Full House").setValue(Integer.toString(checkFullHouse()));
        options.get("4 of a Kind").setValue(Integer.toString(check4ofAKind()));
        options.get("Straight").setValue(Integer.toString(checkStraight(dices)));
        options.get("YAHTZEE").setValue(Integer.toString(checkYahtzee()));
    }

    private int checkFullHouse(){
        boolean has_2 = false;
        boolean has_3 = false;
        for(int count : occurrences.values()){
            if(count == 2){
                has_2 = true;
            }
            if (count == 3){
                has_3 = true;
            }
        }
        if(has_2 && has_3){
            return 20;
        }
        return 0;
    }

    private int check4ofAKind(){
        for(int count : occurrences.values()){
            if(count == 4){
                return 30;
            }
        }
        return 0;
    }

    private int checkStraight(DiceTable dices){
        if(occurrences.get(dices.getDices().get("Dice 1")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 2")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 3")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 4")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 5")) == 1){
            return 40;
        } else if(occurrences.get(dices.getDices().get("Dice 6")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 2")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 3")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 4")) == 1 &&
                occurrences.get(dices.getDices().get("Dice 5")) == 1){
            return 40;
        }
        return 0;
    }

    private int checkYahtzee(){
        for(int count : occurrences.values()){
            if(count == 5){
                return 50;
            }
        }
        return 0;
    }

    public HashMap<String, Option> getOptions() {
        return options;
    }
}
