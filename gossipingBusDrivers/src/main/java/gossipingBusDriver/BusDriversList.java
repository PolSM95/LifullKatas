package gossipingBusDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusDriversList {
    List<BusDriver> busDriverList;

    public BusDriversList(List<BusDriver> busDriverList) {
        this.busDriverList = busDriverList;
    }

    public boolean isFinished(){

        for (BusDriver busDriver: busDriverList ) {

            if(busDriver.gossipNumber() != busDriverList.size()){
                return false;
            }
        }
        return true;

    }


    public void nextStep(){

        for (BusDriver busDriver : busDriverList) {
            busDriver.nextStop();
        }

        for (BusDriver busDriver : busDriverList) {
            List<BusDriver> driversList = busDriverList.stream().
                    filter(driver -> driver.sameStop(busDriver)).
                    collect(Collectors.toList());

            transferGossipsFromOtherDrivers(busDriver, driversList);
        }
    }

    private void transferGossipsFromOtherDrivers(BusDriver busDriver, List<BusDriver> driversList) {
        for (BusDriver otherBusDriver : driversList) {
            busDriver.addGossipDriver(otherBusDriver);
        }
    }

}

