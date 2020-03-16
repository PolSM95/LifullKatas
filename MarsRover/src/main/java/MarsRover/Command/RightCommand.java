package MarsRover.Command;

import MarsRover.MarsRoverBase;

public class RightCommand implements Command {


    private MarsRoverBase marsRover;

    public RightCommand(MarsRoverBase marsRover) {


        this.marsRover = marsRover;
    }

    @Override
    public void execute() {
        marsRover.rotateRight();
    }
}
