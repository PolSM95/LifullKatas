package gossipingBusDriver;

import java.util.ArrayList;
import java.util.List;

public class BusDriversList {
    List<BusDriver> busDriverList;

    public BusDriversList(List<BusDriver> busDriverList) {
        this.busDriverList = busDriverList;
    }

    public List<Integer> nextDriver() {
        List<Integer> currentStops = new ArrayList();
        for (BusDriver busDriver : busDriverList) {
            currentStops.add(busDriver.nextStop());
        }
        return currentStops;
    }
}