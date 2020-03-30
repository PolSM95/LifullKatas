package unit;

import gossipingBusDriver.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusDriverShould {

    Console console;
    GossipController gossipController;
    BusDriversList busDriversList;
    BusDriversApp busDriversApp;


    @Test
    public void init(){
        console = mock(Console.class);
    }

    @Test
    public void test(){
        BusDriver busDriverA = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(1, 2))));
        BusDriver busDriverB = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(3, 2))));

        List <BusDriver> driverList = new ArrayList<>();
        driverList.add(busDriverA);
        driverList.add(busDriverB);

        busDriversList = new BusDriversList(driverList);
        gossipController = new GossipController(busDriversList);
        busDriversApp = new BusDriversApp(console,gossipController);

        verify(console).printline("2");

    }
}
