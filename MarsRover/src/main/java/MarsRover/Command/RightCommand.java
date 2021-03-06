package MarsRover.Command;

import MarsRover.MarsRover;

public class RightCommand implements Command {


    private MarsRover marsRover;

    public RightCommand(MarsRover marsRover) {


        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.rotateRight();
    }
}
