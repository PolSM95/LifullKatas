import java.util.HashMap;

public class RomansConverter {

    HashMap <String , Integer > romanValues = new HashMap < String , Integer >();

    public String romanConversion(int number) {

        String romanNumber = "";



        if (number == 5){
            romanNumber = "V";
            return romanNumber;
        }

        if (number == 10){
            romanNumber = "X";
            return romanNumber;
        }



        for(int i = 1 ; i <= number;  i++){
            romanNumber += "I";
        }
        return romanNumber;
    }


}
