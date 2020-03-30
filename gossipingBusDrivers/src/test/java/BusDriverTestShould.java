import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BusDriverTestShould {

    Console console;
    GossipController gossipController;
    BusDriversApp busDriversApp;

    @BeforeEach
    public void initTests(){
        console = mock(Console.class);
        gossipController= mock(GossipController.class);
        busDriversApp = new BusDriversApp(console);
    }

    @Test
    public void test(){


        BusDriver busDriverA = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(1, 2))));
        BusDriver busDriverB = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(3, 2))));

        List<BusDriver> busDriverList = new ArrayList<BusDriver>(Arrays.asList(busDriverA, busDriverB));

        busDriversApp.main(busDriverList);

        verify(gossipController).checkStop(false);

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




