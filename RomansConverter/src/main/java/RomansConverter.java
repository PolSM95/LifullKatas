import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomansConverter {

    LinkedHashMap <String , Integer > romanValues = new LinkedHashMap< String , Integer >();

    public String romanConversion(int number) {
        romanValues.put("M", 1000);
        romanValues.put("CM", 900);
        romanValues.put("D", 500);
        romanValues.put("CD", 400);
        romanValues.put("C", 100);
        romanValues.put("XC", 90);
        romanValues.put("L", 50);
        romanValues.put("XL", 40);
        romanValues.put("X", 10);
        romanValues.put("IX", 9);
        romanValues.put("V", 5);
        romanValues.put("IV", 4);
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
       return romanNumber;
    }

}
