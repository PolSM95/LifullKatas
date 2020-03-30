import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BusDriversAcceptanceShould {

    @Test
    public void  testAcceptance(){

        Console console = mock(Console.class);
        BusDriversApp busDriversApp = new BusDriversApp();

        int[][] routes = {
                {3, 1, 2, 3},
                {3, 2, 3, 1},
                {4, 2, 3, 4, 5}
        };

        busDriversApp.main(routes);

        verify(console).printline("5");
    }
}
