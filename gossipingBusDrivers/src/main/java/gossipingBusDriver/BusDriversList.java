package gossipingBusDriver;

import java.util.ArrayList;
import java.util.List;

public class BusDriversList {
    List<BusDriver> busDriverList;

    public BusDriversList(List<BusDriver> busDriverList) {
        this.busDriverList = busDriverList;
    }

    public List<Integer> nextDriver() {

        /*boolean match = false;
        for (int driversNum = 0; driversNum <= busDriverList.size(); driversNum++ ){

            int firstStop = busDriverList.get(driversNum).route.routeDriver.get(0);

            for (int indexDriveComparator = 1; indexDriveComparator <= busDriverList.size(); indexDriveComparator++ ){

                int otherStop = busDriverList.get(indexDriveComparator).route.routeDriver.get(0);

                if (firstStop == otherStop){

                    match =true;
                }
            }
        }*/

        List<Integer> currentStops = new ArrayList();
        List<Integer> matchingStops = new ArrayList();
        for (BusDriver busDriver : busDriverList) {
            currentStops.add(busDriver.nextStop());
        }
        for (int actualStop : currentStops) {
            for (int index = 1; index < currentStops.size(); index++){
                if(actualStop == currentStops.get(index)){
                    matchingStops.add(currentStops.get(index));
                }
            }
        }
        return currentStops;
    }
}