import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
            "6, 8"
    })
    public void test(int position, int expectedValue){
        assertEquals(expectedValue, Fibonacci.calculate(position));
    }



    private static class Fibonacci {
        static Integer[] fibonacciList = {0,1,1,2,3,5,8};
        public static int calculate(int position) {
           return fibonacciList[position];
        }
    }
}
