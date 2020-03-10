package MarsRover.Command;

import MarsRover.MarsRover;

public class ForwardCommand implements Command {
    private MarsRover marsRover;

    public ForwardCommand(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.moveForward();
    }
}
