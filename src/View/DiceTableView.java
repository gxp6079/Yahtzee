package View;

import Controle.DiceTable;
import javafx.scene.layout.GridPane;

public class DiceTableView {

    private GridPane view;
    private DiceTable diceTable;

    public DiceTableView (){
        this.diceTable =  new DiceTable();
        this.view = new GridPane();
        /*
        Latter this will change to represent the number this dice has in the dice table
         */
        DiceView diceCB0 = new DiceView("Dice 1",
                diceTable.getDices().get("Dice 1").getCurrentValue());
        diceTable.getDices().get("Dice 1").addObserver(diceCB0);
        view.add(diceCB0.getView(), 0, 0);
        DiceView diceCB1 = new DiceView("Dice 2",
                diceTable.getDices().get("Dice 2").getCurrentValue());
        diceTable.getDices().get("Dice 2").addObserver(diceCB1);
        view.add(diceCB1.getView(), 8, 0);
        DiceView diceCB2 = new DiceView("Dice 3",
                diceTable.getDices().get("Dice 3").getCurrentValue());
        diceTable.getDices().get("Dice 3").addObserver(diceCB2);
        view.add(diceCB2.getView(), 4, 4);
        DiceView diceCB3 = new DiceView("Dice 4",
                diceTable.getDices().get("Dice 4").getCurrentValue());
        diceTable.getDices().get("Dice 4").addObserver(diceCB3);
        view.add(diceCB3.getView(), 0, 8);
        DiceView diceCB4 = new DiceView("Dice 5",
                diceTable.getDices().get("Dice 5").getCurrentValue());
        diceTable.getDices().get("Dice 5").addObserver(diceCB4);
        view.add(diceCB4.getView(), 8, 8);
    }

    public GridPane getView() {
        return view;
    }

    public DiceTable getDiceTable(){
        return diceTable;
    }

}
