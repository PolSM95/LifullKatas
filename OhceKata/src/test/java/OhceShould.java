import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OhceShould {
    @Test
    public void Test(){

        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output);

        ohce.init("Pedro");


    }
}
