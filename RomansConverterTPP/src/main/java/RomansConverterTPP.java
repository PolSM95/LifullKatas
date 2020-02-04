import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class RomansConverterTPP {
    HashMap <Integer, String > romanNumbers = new LinkedHashMap<>();

    public RomansConverterTPP() {
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
    }

    public String romanConversion(int number) {
        if (romanNumbers.containsKey(number)){
            return romanNumbers.get(number);
        }
        if (number > 5){
            return "V" + romanConversion(number - 5);
        }
        return "I" + romanConversion(number - 1);
    }
}
