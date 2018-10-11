package View;

import Controle.Game;
import Controle.ScoreOptions;
import Controle.ScoreTable;
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
    Game game;
    ScoreOptionsView scoreOptionsView;

    public YahtzeeUI (){
        this.game = new Game();
        this.diceTableView =  new DiceTableView(game.getDiceTable());
        this.scoreBoardView = new ScoreBoardView(game.getScoreTable());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        HBox hBox1 = new HBox(diceTableView.getView(), scoreBoardView.getView());
        Button rollButton = new Button("Roll");
        Button selectButton = new Button("Select");
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
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isSelected = false;
                for(Node node : scoreOptionsView.getView().getChildren()){
                    CheckBox checkBox = (CheckBox) (node);
                    int max = checkBox.getText().length();
                    String optionName = "";
                    for (int i = 0 ; i < max; i++){
                        if(checkBox.getText().substring(0, i).contains(":")){
                            optionName = checkBox.getText().substring(0, i -2);
                        }
                    }
                    if(!isSelected){
                        isSelected = checkBox.isSelected();
                        scoreBoardView.getScoreTable().addScore(game.getCurrent(), scoreOptionsView.getScoreOptions().getOptions().get(optionName));
                    }
                    scoreOptionsView.getScoreOptions().getOptions().get(optionName).setSelection(isSelected);
                }
            }
        });
        HBox hBox2 = new HBox(rollButton);
        HBox hBox3 = new HBox(selectButton);
        VBox vBox = new VBox(hBox1, hBox2, hBox3);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
