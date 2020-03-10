package MarsRover.Command;

import MarsRover.MarsRover;

public class BackwardCommand implements Command {
    private MarsRover marsRover;

    public BackwardCommand(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.moveBackwards();
    }
}
