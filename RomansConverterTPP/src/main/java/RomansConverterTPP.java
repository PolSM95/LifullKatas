import java.util.ArrayList;
import java.util.List;

public class RomansConverterTPP {
    public String romanConversion(int number) {
        List<String> romanNumbers = new ArrayList<>();
        romanNumbers.add("I");
        romanNumbers.add("II");
        romanNumbers.add("III");

        return romanNumbers.get(number - 1);
    }
}
