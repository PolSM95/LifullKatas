package gossipingBusDriver;

public class GossipController {

    private final BusDriversList busDriversList;

    public GossipController(BusDriversList busDriversList) {

        this.busDriversList = busDriversList;

    }

    public boolean checkStop() {
        return false;
    }

    public void nextStep() {
        throw new UnsupportedOperationException();
    }

    public boolean isFinished() {
        throw new UnsupportedOperationException();
    }
}
