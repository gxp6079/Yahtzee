package Controle;

import java.util.HashMap;

public class ScoreOptions {

    private HashMap<String, Option> options;
    private HashMap<Dice, Integer> occurencies;

    public ScoreOptions(DiceTable dices){
        this.options = new HashMap<>();
        this.occurencies = new HashMap<>();
        options.put("One", new Option());
        options.put("Two", new Option());
        options.put("Three", new Option());
        options.put("Four", new Option());
        options.put("Five", new Option());
        options.put("Six", new Option());
        options.put("Full House", new Option());
        options.put("4 of a Kind", new Option());
        options.put("Straight", new Option());
        options.put("YAHTZEE", new Option());
        setOptions(dices);
    }

    public void setOptions(DiceTable dices){
        for(Dice dice : dices.getDices().values()){
            if(occurencies.containsKey(dice)){
                occurencies.replace(dice, occurencies.get(dice) + 1);
            }else {
                occurencies.put(dice, 1);
            }
        }
        for(Dice dice : occurencies.keySet()){
            options.get(dice.getName()).setValue(Integer.toString(occurencies.get(dice))));
        }
        options.get("Full House").setValue(Integer.toString(checkFullHouse()));
        options.replace("4 of a Kind", Integer.toString(check4ofAKind()));
        options.replace("Straight", Integer.toString(checkStraight(dices)));
        options.replace("YAHTZEE", Integer.toString(checkYahtzee()));
    }

    private int checkFullHouse(){
        boolean has_2 = false;
        boolean has_3 = false;
        for(int count : occurencies.values()){
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
        for(int count : occurencies.values()){
            if(count == 4){
                return 30;
            }
        }
        return 0;
    }

    private int checkStraight(DiceTable dices){
        if(occurencies.get(dices.getDices().get("Dice 1")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 2")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 3")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 4")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 5")) == 1){
            return 40;
        } else if(occurencies.get(dices.getDices().get("Dice 6")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 2")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 3")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 4")) == 1 &&
                occurencies.get(dices.getDices().get("Dice 5")) == 1){
            return 40;
        }
        return 0;
    }

    private int checkYahtzee(){
        for(int count : occurencies.values()){
            if(count == 5){
                return 50;
            }
        }
        return 0;
    }

    public HashMap<String, String> getOptions() {
        return options;
    }
}
