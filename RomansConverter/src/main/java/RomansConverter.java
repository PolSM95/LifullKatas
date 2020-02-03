public class RomansConverter {
    public String romanConversion(int number) {

        String romanNumber = "";

        for(int i = 1 ; i <= number;  i++){
            romanNumber += "I";
        }
        return romanNumber;
    }
}
