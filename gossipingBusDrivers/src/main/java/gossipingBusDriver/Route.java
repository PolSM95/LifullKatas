package gossipingBusDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Route {

    List<Integer> routeDriver = new ArrayList<Integer>();
    Iterator interatorRoute;
    int currentStop;


    public Route(List<Integer> routeDriver) {
        this.interatorRoute = routeDriver.iterator();
        this.routeDriver = routeDriver;
    }

    public int nextStop() {
        if (!interatorRoute.hasNext()) {
            interatorRoute = routeDriver.iterator();

        }
        currentStop = (int) interatorRoute.next();
        return currentStop;
    }
}