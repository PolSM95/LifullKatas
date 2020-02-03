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
        int countRepeatNum = 0;
        Map.Entry <String, Integer> lastEntry;


        for (Map.Entry<String, Integer> entryRomanValues : romanValues.entrySet()) {
            String keyRomanChar = entryRomanValues.getKey();
            Integer valueRomanNumber = entryRomanValues.getValue();


            while(restNumber >= valueRomanNumber){
                if(countRepeatNum > 3){


                }else{
                    restNumber -= valueRomanNumber;
                    romanNumber += keyRomanChar;
                }
                countRepeatNum++;
            }

            countRepeatNum = 0;
            lastEntry = entryRomanValues;
        }

       return romanNumber;
    }

}
