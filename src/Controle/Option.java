package Controle;

public class Option {

    String value;
    boolean selection;
    String name;

    public Option(String name){
        this.name = name;
        this.value = "0";
        this.selection = false;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public String getName() {
        return name;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }
}
