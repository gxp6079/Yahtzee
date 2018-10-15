package View;

import Controle.Game;
import Controle.ScoreTable;
import Model.ScoreObserver;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class ScoreBoardView implements ScoreObserver {
    VBox view;
    ScoreTable scoreTable;
    public ScoreBoardView(ScoreTable scoreTable){
        this.view = new VBox();
        this.scoreTable = scoreTable;
        HBox header = new HBox();
        Label types = new Label("Types");
        Label player1name = new Label(Game.getPlayer1().getName());
        Label player2name = new Label(Game.getPlayer2().getName());
        header.getChildren().add(0, types);
        header.getChildren().add(1, player1name);
        header.getChildren().add(2, player2name);
        view.getChildren().add(header);
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

    public VBox getView() {
        return view;
    }
}
