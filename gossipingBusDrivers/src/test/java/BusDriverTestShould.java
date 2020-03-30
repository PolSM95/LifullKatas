import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BusDriverTestShould {

    Console console;
    BusDriversApp busDriversApp;

    @BeforeEach
    public void initTests(){
        Console console = mock(Console.class);
        BusDriversApp busDriversApp = new BusDriversApp();
    }

    @Test
    public void test(){

        int[][] routes = {
                {1,1, 2},
                {3, 2}
        };

        busDriversApp.main(routes);
        verify(console).printline("1");


    }
}

/*1   1   2
3   3   2

1   2   1
3   2   3

2   1   1
2   3   3

1   1   2
3   3   2*/




