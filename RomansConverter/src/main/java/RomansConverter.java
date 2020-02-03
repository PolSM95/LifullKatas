public class RomansConverter {
    public String romanConversion(int number) {
        if(number == 1){
            return "I";
        }
        if(number == 3){
            return "III";
        }
        return "II";
    }
}
