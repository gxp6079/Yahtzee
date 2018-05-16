package Controle;

public class Pair {

    private String scoreType;
    private int value;

    public Pair(String scoreType, int value){
        this.scoreType = scoreType;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getScoreType() {
        return scoreType;
    }
}
