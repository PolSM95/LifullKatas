package MarsRover.Command;

import MarsRover.Position;

public class ForwardCommand implements Command {
    private Position position;

    public ForwardCommand(Position position) {
        this.position = position;
    }

    @Override
    public void execute() {
        position.moveForward();
    }
}
