package Controle;

import Interfaces.DiceInterface;
import Model.DiceObserver;

import java.util.ArrayList;
import java.util.Random;
/*
commit
 */

public class Dice implements DiceInterface{

    private int value;
    private String name;
    private boolean selected;
    private Random random;
    private ArrayList<DiceObserver> observers;

    public Dice (String name){
        this.observers = new ArrayList<>();
        this.name = name;
        random = new Random();
    }

    public void addObserver(DiceObserver observer){
        observers.add(observer);
    }

    public DiceObserver removeOberver(DiceObserver observer){
        if(observers.remove(observer)){
            return observer;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getCurrentValue() {
        return value;
    }

    @Override
    public boolean getSelection() {
        return selected;
    }

    @Override
    public void setSelection(boolean selection) {
        this.selected = selection;
    }

    @Override
    public void roll() {
        this.value = random.nextInt(5) + 1;
        for (DiceObserver observer : observers){
            observer.update(this);
        }
    }

}
