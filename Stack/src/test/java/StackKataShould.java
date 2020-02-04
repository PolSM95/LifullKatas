import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StackKataShould {
    @Test
    public void throwExceptionIfPopIsEmptyFromStack(){
        StackKata stackKata = new StackKata();
        assertThrows(RuntimeException.class,()->{stackKata.pop();});
    }
    @Test
    public void increaseTheLengthOfTheStackFirstTime(){
        StackKata stackKata = new StackKata();
        stackKata.push("one");
        assertEquals(1,stackKata.getLength());
    }
    @Test
    public void showTheFirstElementInStack(){
        StackKata stackKata = new StackKata();
        stackKata.push("one");
        assertEquals("one",stackKata.pop());
    }

    @Test
    public void checkSecondElementFromStack(){
        StackKata stackKata = new StackKata();
        stackKata.push("one");
        stackKata.push("two");
        assertEquals("two", stackKata.pop());
    }

    @Test
    public void recoveryPenultimateElementFromStack(){
        StackKata stackKata = new StackKata();
        stackKata.push("one");
        stackKata.push("two");
        stackKata.push("three");
        stackKata.pop();
        assertEquals("two", stackKata.pop());
    }
}
