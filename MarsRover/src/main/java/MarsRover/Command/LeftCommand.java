package MarsRover.Command;

import MarsRover.Position;

public class LeftCommand implements Command {


    private Position position;

    public LeftCommand(Position position) {


        this.position = position;
    }

    @Override
    public void execute() {
        position.rotateLeft();
    }
}
