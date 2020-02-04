import java.util.*;

public class RomansConverterTPP {
    HashMap <Integer, String > romanNumbers = new LinkedHashMap<>();

    public RomansConverterTPP() {
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "CM");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");

    }

    public String romanConversion(int number) {
        if (romanNumbers.containsKey(number)){
            return romanNumbers.get(number);
        }

        for (Integer arabic : romanNumbers.keySet()) {
            if (number > arabic){
                return romanNumbers.get(arabic) + romanConversion(number - arabic);
            }

        }
        return "";
    }
}
