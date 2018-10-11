package Controle;

import java.util.HashMap;

public class ScoreOptions {

    private HashMap<String, String> options;
    private HashMap<Dice, Integer> occurencies;

    public ScoreOptions(DiceTable dices){
        this.options = new HashMap<>();
        this.occurencies = new HashMap<>();
        options.put("One", "0");
        options.put("Two", "0");
        options.put("Three", "0");
        options.put("Four", "0");
        options.put("Five", "0");
        options.put("Six", "0");
        options.put("Full House", "0");
        options.put("4 of a Kind", "0");
        options.put("Straight", "0");
        options.put("YAHTZEE", "0");
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
            options.replace(dice.getName(), Integer.toString(occurencies.get(dice)));
        }
        options.replace("Full House", Integer.toString(checkFullHouse()));
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

}
