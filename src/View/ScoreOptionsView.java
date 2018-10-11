package View;

import Controle.ScoreOptions;
import Model.ScoreOptionsObserver;
import javafx.scene.layout.VBox;

public class ScoreOptionsView implements ScoreOptionsObserver {

    VBox view;
    ScoreOptions scoreOptions;

    public ScoreOptionsView(ScoreOptions scoreOptions){
        this.view = new VBox();
        this.scoreOptions = scoreOptions;
    }

    public VBox getView() {
        return view;
    }

    public ScoreOptions getScoreOptions() {
        return scoreOptions;
    }

    @Override
    public void update(ScoreOptions scoreOptions) {

    }
}
