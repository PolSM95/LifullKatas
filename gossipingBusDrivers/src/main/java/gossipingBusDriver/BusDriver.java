package gossipingBusDriver;

import java.util.ArrayList;
import java.util.List;

public class BusDriver {
    public Route route;
    public List<BusDriver> busDriversGossips;

    public BusDriver(Route route){

        this.route = route;
        busDriversGossips = new ArrayList<>();
        busDriversGossips.add(this);
    }

    public int nextStop() {
       return route.nextStop();
    }

    public boolean sameStop(BusDriver busDriver){

        return (busDriver.route.stopNumber() == route.stopNumber());
    }

    public int gossipNumber() {
        return busDriversGossips.size();
    }

    public void addGossipDriver(BusDriver busDriver){
        if(!busDriversGossips.contains(busDriver)){
            busDriversGossips.add(busDriver);
        }
    }
}