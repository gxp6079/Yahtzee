package Controle;

public class Game {

    private static Player player1;
    private static Player player2;
    private ScoreTable scoreTable;
    private ScoreOptions scoreOptions;
    private DiceTable diceTable;
    private static Player current;

    public Game(){
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.current = player1;
        this.scoreTable = new ScoreTable(player1, player2);
        this.diceTable = new DiceTable();
        this.scoreOptions = new ScoreOptions(diceTable);
    }

    public Player getCurrent(){return current;}

    public static void setCurrent(){
        if(current == player1){
            current = player2;
        }else{
            current = player1;
        }
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public ScoreTable getScoreTable() {
        return scoreTable;
    }

    public ScoreOptions getScoreOptions() {
        return scoreOptions;
    }

    public DiceTable getDiceTable() {
        return diceTable;
    }
}

