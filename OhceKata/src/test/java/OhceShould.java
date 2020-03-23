import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class OhceShould {
    @Test
    public void verify_that_console_recieves_welcome_message(){

        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output);

        ohce.init("Pedro");

        verify(output).showOutput("¡Buenos días Pedro!");
    }

}
