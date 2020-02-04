import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorsShould {
    @Test
    public void return_two_when_factorize_two(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        assertEquals(expectedList, primeFactor.factorize(2));
    }
    @Test
    public void return_three_when_factorize_three(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(3);
        assertEquals(expectedList,primeFactor.factorize(3));
    }
    @Test
    public void return_five_when_factorize_five(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(5);
        assertEquals(expectedList, primeFactor.factorize(5));
    }
    @Test
    public void return_prime_list_numbers_when_factorize_four(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(2);
        assertEquals(expectedList, primeFactor.factorize(4));
    }
    @Test
    public void return_prime_list_numbers_when_factorize_six(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(3);
        assertEquals(expectedList, primeFactor.factorize(6));
    }
    @Test
    public void return_prime_list_numbers_when_factorize_eight(){
        PrimeFactors primeFactor = new PrimeFactors();
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(2);
        expectedList.add(2);
        assertEquals(expectedList, primeFactor.factorize(8));
    }
}
