import java.util.*;

public class RomansConverterTPP {
    HashMap <Integer, String > romanNumbers = new LinkedHashMap<>();
    Iterator iteratorRomanNumbers;
    public RomansConverterTPP() {
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
        iteratorRomanNumbers = romanNumbers.entrySet().iterator();

    }

    public String romanConversion(int number) {
        if (romanNumbers.containsKey(number)){
            return romanNumbers.get(number);
        }
        if (number > 40){
            return "XL" + romanConversion(number - 40);
        }
        if (number > 10){
            return "X" + romanConversion(number - 10);
        }
        if (number > 5){
            return "V" + romanConversion(number - 5);
        }
        return "I" + romanConversion(number - 1);
    }
}
