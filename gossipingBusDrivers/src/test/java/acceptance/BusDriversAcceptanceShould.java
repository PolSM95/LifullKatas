package acceptance;

import gossipingBusDriver.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BusDriversAcceptanceShould {

    @Test
    public void  testAcceptance(){
        Console console = mock(Console.class);

        BusDriver busDriverA = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(3, 1, 2, 3))));
        BusDriver busDriverB = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(3, 2, 3, 1))));
        BusDriver busDriverC = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5))));

        List<BusDriver> busDriverList = new ArrayList<BusDriver>(Arrays.asList(busDriverA, busDriverB, busDriverC));
        BusDriversList driverList = new BusDriversList(busDriverList);
        GossipController gossipController = new GossipController(driverList);
        BusDriversApp busDriversApp = new BusDriversApp(console, gossipController);

        busDriversApp.main();

        verify(console).printline("5");
    }
}

//No direct interaction start in 1

/*3 1 2 3
3 2 3 1
4 2 3 4 5

1 2 3 3
2 3 1 3
2 3 4 5 4

2 3 3 1
3 1 3 2
3 4 5 4 2

3 3 1 2
1 3 2 3
4 5 4 2 3

3 1 2 3
3 2 3 1
5 4 2 3 4

1 2 3 3
2 3 1 3
4 2 3 4 5

2 3 3 1
3 1 3 2
2 3 4 5 4*/