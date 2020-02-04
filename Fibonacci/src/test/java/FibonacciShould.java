import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciShould {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "9, 34"
    })
    public void validate_fibonacci_serie(int position, int expectedValue){
        assertEquals(expectedValue, Fibonacci.calculateIterative(position));
    }



    private static class Fibonacci {
        public static int calculate(int position) {
            if (position < 2){
                return position;
            }
           return calculate(position - 1) + calculate(position - 2);
        }

        public static int calculateIterative (int position){
            if (position < 2){
                return position;
            }
            Integer[] fibonacciSerie = {0,1,0};
            for (int i = 2; i <= position; i++){
                fibonacciSerie[2] = fibonacciSerie[0] + fibonacciSerie[1];
                fibonacciSerie[0] = fibonacciSerie[1];
                fibonacciSerie[1] = fibonacciSerie[2];
            }
            return fibonacciSerie[1];
        }
    }


}
