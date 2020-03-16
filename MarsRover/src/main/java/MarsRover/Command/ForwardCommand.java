package MarsRover.Command;

import MarsRover.MarsRoverBase;

public class ForwardCommand implements Command {
    private MarsRoverBase marsRover;

    public ForwardCommand(MarsRoverBase marsRoverBase) {
        this.marsRover = marsRoverBase;
    }

    @Override
    public void execute() {
        marsRover.moveForward();
    }
}
