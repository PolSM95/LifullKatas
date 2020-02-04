import java.text.DecimalFormat;

public class StringCalculator {
        public String add (String numbers) {

            String separator = ",";

            if (numbers == "") {
                return "0";
            }
            if(numbers.startsWith("//")){

                separator = numbers.substring(2,numbers.indexOf("\n"));
                numbers = numbers.substring(numbers.indexOf("\n") + 1);
                if(numbers.contains(",")){
                    return "'" + separator + "' expected but ',' found at position " + numbers.indexOf(",") + ".";
                }
            }
            if (!numbers.contains(separator) && !numbers.contains("\n")) {
                return numbers;
            }
            if(numbers.charAt(numbers.length()-1) == ','){
                return "Number expected but EOF found.";
            }
            if(numbers.indexOf(",\n") != -1){
                return "Number expected but '\\n' found at position " + numbers.indexOf("\n") + ".";
            }
            if(separator.equals("|")){
                separator = "\\" + separator ;
            }
            String[] numberList = numbers.split(separator + "|\\n");
            return addOperation(numberList);
        }

    private String addOperation(String[] numberList) {
        float result = 0;
        for (String element : numberList) {
            result += Float.parseFloat(element);
        }
        DecimalFormat format = new DecimalFormat("0.##");
        return format.format(result).replace(',','.');
    }
}
