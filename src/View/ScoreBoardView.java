package View;

import Model.ScoreObserver;
import javafx.scene.layout.VBox;

public class ScoreBoardView implements ScoreObserver {
    VBox view;
    public ScoreBoardView(){
        this.view = new VBox();
    }

    public VBox getView() {
        return view;
    }
}
