package Controle;

import Model.DiceObserver;
import Model.ScoreOptionsObserver;

import java.util.ArrayList;

public class Option{
    private int value;
    private String name;
    private boolean selected;
    private ArrayList<ScoreOptionsObserver> observers;

    public Option(String name){
        this.observers = new ArrayList<>();
        this.name = name;
    }
    public void addObserver(ScoreOptionsObserver observer){
        observers.add(observer);
    }

    public ScoreOptionsObserver removeOberver(ScoreOptionsObserver observer){
        if(observers.remove(observer)){
            return observer;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getCurrentValue() {
        return value;
    }

    public boolean getSelection() {
        return selected;
    }

    public void setSelection(boolean selection) {
        this.selected = selection;
    }

}
