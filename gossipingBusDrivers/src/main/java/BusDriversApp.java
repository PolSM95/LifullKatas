import java.util.List;

public class BusDriversApp {

    private Console console;
    private GossipController gossipController;


    public BusDriversApp(Console console, GossipController gossipController){

        this.console = console;

        this.gossipController = gossipController;
    }

    public void main(BusDriversList busDriverList) {

        int totalSteps;
        for (totalSteps = 0; totalSteps < 480; ++totalSteps){
            gossipController.nextStep();

            if (gossipController.isFinished()){
                console.printline(Integer.toString(totalSteps+1));
                break;
            }
        }
        if (totalSteps == 480){
            console.printline("never");
        }
    }
}
