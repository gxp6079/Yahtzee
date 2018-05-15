package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YahtzeeUI extends Application {

    DiceTableView diceTableView;
    Stage primaryStage;
    ScoreBoardView scoreBoardView;

    public YahtzeeUI (){
        this.diceTableView =  new DiceTableView();
        this.scoreBoardView = new ScoreBoardView();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        HBox hBox1 = new HBox(diceTableView.getView(), scoreBoardView.getView());
        Button rollButton = new Button("Roll");
        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(Node node : diceTableView.getView().getChildren()){
                    CheckBox checkBox = (CheckBox) (node);
                    boolean isSelected = checkBox.isSelected();
                    String diceTableName = checkBox.getText().substring(0, 6);
                    diceTableView.getDiceTable().getDices().get(diceTableName).setSelection(isSelected);
                }
                diceTableView.getDiceTable().roll();
            }
        });
        HBox hBox2 = new HBox(rollButton);
        VBox vBox = new VBox(hBox1, hBox2);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
