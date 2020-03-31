package unit;

import gossipingBusDriver.BusDriver;
import gossipingBusDriver.BusDriversList;
import gossipingBusDriver.Route;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BusDriverListShould {

    List<BusDriver> driversList;


    @Test
    public void verify_that_all_busDrivers_share_gossips_at_the_first_stop(){

        BusDriver busDriverA = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(2,1))));
        BusDriver busDriverB = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(2,2))));
        BusDriver busDriverC = new BusDriver(new Route(new ArrayList<Integer>(Arrays.asList(2,4))));
        driversList = new ArrayList<>();

        driversList.add(busDriverA);
        driversList.add(busDriverB);
        driversList.add(busDriverC);

        BusDriversList busDriversList = new BusDriversList(driversList);

        busDriversList.nextStep();

        assertTrue(busDriversList.isFinished());


    }
}
