import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StacK2Should {
    @Test
    public void throws_exception_if_stack_is_empty(){
        Stack2 stack2 = new Stack2();
        assertThrows(RuntimeException.class,()->{stack2.pop();});
    }

    @Test
    public void introducing_one_in_stack(){
        Stack2 stack2 = new Stack2();
        stack2.push("One");
        assertEquals(1, stack2.length);
    }

    @Test
    public void introducing_one_and_two_in_stack(){
        Stack2 stack2 = new Stack2();
        stack2.push("One");
        stack2.push("Two");
        assertEquals(2, stack2.length);
    }

    @Test
    public void input_of_two_elements_and_deleting_one(){
        Stack2 stack2 = new Stack2();
        stack2.push("One");
        stack2.push("Two");
        stack2.pop();
        assertEquals(1, stack2.length);
    }


}
