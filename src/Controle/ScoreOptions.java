package Controle;

import Model.ScoreOptionsObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ScoreOptions {
    private Collection<Dice> dices;
    private HashMap<String, Integer> options;
    private HashMap<Integer, Integer> occurencies;
    private String selected;
    private boolean hasSelected = false;
    private ArrayList<ScoreOptionsObserver> observers;

    public ScoreOptions(Collection<Dice> dices){
        this.dices = dices;
        this.occurencies = new HashMap<>();
        for (Dice dice : dices){
            if (occurencies.keySet().contains(dice.getCurrentValue())){
                occurencies.replace(dice.getCurrentValue(), occurencies.get(dice.getCurrentValue()) + 1);
            }
            else{
                occurencies.put(dice.getCurrentValue(), 1);
            }
        }
        this.options =  new HashMap<>();
        setOptions();
    }

    private void setOptions(){
        options.put("Ones", occurencies.get(1));
        options.put("Twos", 2*(occurencies.get(2)));
        options.put("Threes", 3*(occurencies.get(3)));
        options.put("Fours", 4*(occurencies.get(4)));
        options.put("Five", 5*(occurencies.get(5)));
        options.put("Sixes", 6*(occurencies.get(6)));
        options.put("FullHouse", FullHouse());
        options.put("FourOfAKind", FourOfAKind());
        options.put("Straight", Straight());
        options.put("YAHTZEE", Yahtzee());
        for(ScoreOptionsObserver observer : observers){
            observer.update(this);
        }
    }

    public HashMap<String, Integer> getOptions() {
        return options;
    }

    private Integer Yahtzee() {
        for (int num : occurencies.keySet()){
            if (occurencies.get(num) == 5){
                return 50;
            }
        }
        return 0;
    }


    private int Straight() {
        for(int num : occurencies.keySet()){
            if(occurencies.get(num) != 1){
                if(num != 1 && num != 6){
                    return 0;
                }
                else if(num == 1 && occurencies.get(6) != 1){
                    return 0;
                }
                else if (num == 6 && occurencies.get(1) != 1){
                    return 0;
                }
            }
        }
        return 40;
    }

    private int FourOfAKind() {
        for (int num : occurencies.keySet()){
            if(occurencies.get(num) >= 4){
                return 30;
            }
        }
        return 0;
    }

    private int FullHouse() {
        boolean hasTwo = false;
        boolean hasThree = false;
        for(int num : occurencies.keySet()){
            if (occurencies.get(num) == 2){
                hasTwo = true;
            }
            else if (occurencies.get(num) == 3){
                hasThree = true;
            }
        }
        if(hasThree && hasTwo){
            return 20;
        }
        return 0;
    }

    public void start(){
        this.hasSelected = false;
    }

    public void setSelected(String score) throws Exception{
        if(!hasSelected) {
            this.selected = score;
            this.hasSelected = true;
        }
        else {
            /*
            create selected more then one score exception
             */
            throw new Exception();
        }
    }


    public String getSelected() {
        return selected;
    }

    public void addObserver(ScoreOptionsObserver observer){observers.add(observer);}
}
