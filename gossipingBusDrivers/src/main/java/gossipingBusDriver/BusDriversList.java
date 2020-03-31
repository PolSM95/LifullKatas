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

    public boolean isFinished(){

        for (BusDriver busDriver: busDriverList ) {

            if(busDriver.gossipNumber() != busDriverList.size()){
                return false;
            }
        }
        return true;

    }

    public void addDriver(BusDriver busDriver){

    }

    public void nextStep(){
        // mover una posición adelante en el array de rutas de cada driver
        //cmprobar si los drivers estan en la misma parada --> transfieren gossips

        for (BusDriver busDriver : busDriverList) {
            busDriver.nextStop();
        }

        for (BusDriver busDriver : busDriverList) {
            List<BusDriver> driversList = new ArrayList<>();

        }





    }

}

