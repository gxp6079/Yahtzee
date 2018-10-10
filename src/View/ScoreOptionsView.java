package View;

import Controle.ScoreOptions;
import Model.ScoreOptionsObserver;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ScoreOptionsView implements ScoreOptionsObserver{

    private VBox view;
    private ScoreOptions scoreOptions;

    public ScoreOptionsView(ScoreOptions scoreOptions){
        this.view = new VBox();
        this.scoreOptions = scoreOptions;
        scoreOptions.addObserver(this);
    }

    @Override
    public void update(ScoreOptions scoreOptions){
        for(String key : scoreOptions.getOptions().keySet()){
            CheckBox option = new CheckBox(key + " : " + scoreOptions.getOptions().get(key));
            view.getChildren().add(option);
        }
    }
}
