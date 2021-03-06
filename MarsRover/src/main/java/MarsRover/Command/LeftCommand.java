package MarsRover.Command;

import MarsRover.MarsRover;

public class LeftCommand implements Command {


    private MarsRover marsRover;

    public LeftCommand(MarsRover marsRover) {


        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.rotateLeft();
    }
}
