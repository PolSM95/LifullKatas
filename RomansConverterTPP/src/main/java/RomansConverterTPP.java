import java.util.ArrayList;
import java.util.List;

public class RomansConverterTPP {
    List<String> romanNumbers = new ArrayList<>();
    public RomansConverterTPP() {
        romanNumbers.add("I");
        romanNumbers.add("II");
        romanNumbers.add("III");
        romanNumbers.add("IV");
    }

    public String romanConversion(int number) {

        if (number == 1){
            return romanNumbers.get(number - 1);
        }

        if (number == 4){
            return romanNumbers.get(number - 1);
        }

        return "I" + romanConversion(number - 1);



    }
}
