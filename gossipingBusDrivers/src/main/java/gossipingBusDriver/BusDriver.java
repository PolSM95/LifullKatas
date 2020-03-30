package gossipingBusDriver;

public class BusDriver {
    public Route route;

    public BusDriver(Route route){

        this.route = route;
    }

    public int nextStop() {
       return route.nextStop();
    }
}