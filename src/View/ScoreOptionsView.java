package View;

import Controle.ScoreOptions;
import Model.ScoreOptionsObserver;
import javafx.scene.layout.GridPane;

public class ScoreOptionsView implements ScoreOptionsObserver {

    private GridPane view;
    private ScoreOptions scoreOptions;

    @Override
    public void update(ScoreOptions scoreOptions) {
        this.view = new GridPane();
        this.scoreOptions = scoreOptions;


    }
}
