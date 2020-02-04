import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class RomansConverterTPP {
    HashMap <Integer, String > romanNumbers = new LinkedHashMap<>();

    public RomansConverterTPP() {
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
    }

    public String romanConversion(int number) {
        if (romanNumbers.containsKey(number)){
            return romanNumbers.get(number);
        }
        return "I" + romanConversion(number - 1);
    }
}
