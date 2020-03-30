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
        busDriversApp = new BusDriversApp(console, gossipController);
    }

    @Test
    public void print_message_never_when_there_is_no_gossip_shared(){
        /*
        BusDriver busDriverA = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(1, 2))));
        BusDriver busDriverB = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(3, 2))));

         */

        BusDriversList busDriverList = mock(BusDriversList.class);
        when(gossipController.isFinished()).thenReturn(false);
        busDriversApp.main(busDriverList);

        verify(gossipController, times(480)).nextStep();
        verify(console).printline("never");

    }

    @Test
    public void print_number_of_stops_that_takes_to_share_all_the_gossips(){

        BusDriversList busDriverList = mock(BusDriversList.class);
        when(gossipController.isFinished()).thenReturn(false,false, true);
        busDriversApp.main(busDriverList);

        verify(gossipController, times(3)).nextStep();
        verify(console).printline("3");

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




