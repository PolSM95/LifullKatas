package MarsRover.Command;

import MarsRover.MarsRoverBase;

public class LeftCommand implements Command {


    private MarsRoverBase marsRover;

    public LeftCommand(MarsRoverBase marsRover) {


        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.rotateLeft();
    }
}
