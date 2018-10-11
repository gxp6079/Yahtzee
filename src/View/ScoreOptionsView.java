package View;

import Controle.Option;
import Controle.ScoreOptions;
import Model.ScoreOptionsObserver;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class ScoreOptionsView implements ScoreOptionsObserver {

    VBox view;
    ScoreOptions scoreOptions;

    public ScoreOptionsView(ScoreOptions scoreOptions){
        this.view = new VBox();
        this.scoreOptions = scoreOptions;
        for(Option option : scoreOptions.getOptions().values()){
            CheckBox checkBox = new CheckBox(option.getName() + " : " + option.getValue());
            view.getChildren().add(checkBox);
        }
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
