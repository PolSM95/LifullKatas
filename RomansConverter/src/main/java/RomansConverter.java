import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomansConverter {

    LinkedHashMap <String , Integer > romanValues = new LinkedHashMap< String , Integer >();

    public String romanConversion(int number) {
        romanValues.put("M", 1000);
        romanValues.put("D", 500);
        romanValues.put("C", 100);
        romanValues.put("L", 50);
        romanValues.put("X", 10);
        romanValues.put("V", 5);
        romanValues.put("I", 1);

        String romanNumber = "";
        int restNumber = number;

        for (Map.Entry<String, Integer> entryRomanValues : romanValues.entrySet()) {
            String keyRomanChar = entryRomanValues.getKey();
            Integer valueRomanNumber = entryRomanValues.getValue();


            while(restNumber >= valueRomanNumber){
                restNumber -= valueRomanNumber;
                romanNumber += keyRomanChar;
            }
        }

//
//        if (number == 5){
//            romanNumber = "V";
//            return romanNumber;
//        }
//        if (number == 10){
//            romanNumber = "X";
//            return romanNumber;
//        }
//        for(int i = 1 ; i <= number;  i++){
//            romanNumber += "I";
//        }
       return romanNumber;
    }


}
