package View;

import Controle.Dice;
import Model.DiceObserver;
import javafx.scene.control.CheckBox;

public class DiceView implements DiceObserver {

    private CheckBox view;
    String name;

    public DiceView(String name, int value){
        this.name = name;
        this.view = new CheckBox(name + ", value = " + Integer.toString(value));
    }

    public CheckBox getView() {
        return view;
    }

    @Override
    public void update(Dice dice) {
        view.setText(name + ", value = " + Integer.toString(dice.getCurrentValue()));
    }

}
