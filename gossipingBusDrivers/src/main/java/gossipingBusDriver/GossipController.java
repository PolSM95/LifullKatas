package gossipingBusDriver;

public class GossipController {

    private final BusDriversList busDriversList;

    public GossipController(BusDriversList busDriversList) {

        this.busDriversList = busDriversList;

    }


    public void nextStep() {
        busDriversList.nextStep();
    }

    public boolean isFinished() {
        return busDriversList.isFinished();
    }
}
