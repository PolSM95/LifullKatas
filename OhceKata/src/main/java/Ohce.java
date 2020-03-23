import java.io.Console;

public class Ohce {

    OutputOhce output;

    public Ohce(OutputOhce output) {
        this.output = output;
    }


    public void init(String name) {
        output.showOutput("¡Buenos días "+name+"!");
    }
}
