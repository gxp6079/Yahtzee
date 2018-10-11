package View;

import Controle.ScoreTable;
import Model.ScoreObserver;
import javafx.scene.layout.VBox;

public class ScoreBoardView implements ScoreObserver {
    VBox view;
    ScoreTable scoreTable;
    public ScoreBoardView(ScoreTable scoreTable){
        this.view = new VBox();
        this.scoreTable = scoreTable;
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

    public VBox getView() {
        return view;
    }
}
