import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StacK2Should {
    @Test
    public void throws_exception_if_stack_is_empty(){
        Stack2 stack2 = new Stack2();
        assertThrows(RuntimeException.class,()->{stack2.pop();});
    }
}
