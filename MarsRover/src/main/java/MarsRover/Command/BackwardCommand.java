package MarsRover.Command;

import MarsRover.MarsRoverBase;

public class BackwardCommand implements Command {
    private MarsRoverBase marsRover;

    public BackwardCommand(MarsRoverBase marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.moveBackwards();
    }
}
