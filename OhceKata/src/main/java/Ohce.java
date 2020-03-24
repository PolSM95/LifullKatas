import java.io.Console;

public class Ohce {

    OutputOhce output;
    TimeServer timeServer;
    public Ohce(OutputOhce output, TimeServer timeServer) {
        this.output = output;
        this.timeServer = timeServer;
    }

    public Ohce(OutputOhce output) {
        this.output = output;
    }


    public void init(String name) {
        DayTimes dayTimes = timeServer.getTime();
        if (dayTimes == DayTimes.MAÑANA){
            output.showOutput("¡Buenos días "+name+"!");
        }
        if (dayTimes == DayTimes.TARDE){
            output.showOutput("¡Buenas tardes "+name+"!");
        }
        if (dayTimes == DayTimes.NOCHE){
            output.showOutput("¡Buenas noches "+name+"!");

        }
    }

    public void handleWord (String word){

        String reverseWord = reverse(word);
        output.showOutput(reverseWord);
        if (palindrome(word,reverseWord)){
            output.showOutput("¡Bonita Palabra!");
        }
    }

    public String reverse (String word){
        String reverse="";
        for (int index = word.length()-1; index >= 0 ; index--){
            reverse += word.charAt(index);
        }
        return reverse;
    }

    public boolean palindrome (String word, String reverseWord){
        if (reverseWord.equals(word)){
            return  true;
        }
        return false;

    }
}
