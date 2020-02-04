import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    private List<Integer> factorList = new ArrayList<>();
    public List<Integer> factorize(int number) {

        while(number > 1){
            for (int divider = 2; divider <= number; divider++ ){
                while (number % divider == 0) {
                    factorList.add(divider);
                    number = number / divider;
                }
            }
        }
        return factorList;

        /*if(number == 4) {
            factorList.add(2);
            factorList.add(2);
            return factorList;
        }
        if(number == 6) {
            factorList.add(2);
            factorList.add(3);
            return factorList;
        }
        if(number == 8) {
            factorList.add(2);
            factorList.add(2);
            factorList.add(2);
            return factorList;
        }*/

    }
}
