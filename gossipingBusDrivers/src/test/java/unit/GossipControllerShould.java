package unit;

import gossipingBusDriver.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

public class GossipControllerShould {

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

        BusDriversList busDriverList = mock(BusDriversList.class);
        when(gossipController.isFinished()).thenReturn(false);
        busDriversApp.main();

        verify(gossipController, times(480)).nextStep();
        verify(console).printline("never");

    }

    @Test
    public void print_number_of_stops_that_takes_to_share_all_the_gossips(){

        BusDriversList busDriverList = mock(BusDriversList.class);
        when(gossipController.isFinished()).thenReturn(false,false, true);
        busDriversApp.main();

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




