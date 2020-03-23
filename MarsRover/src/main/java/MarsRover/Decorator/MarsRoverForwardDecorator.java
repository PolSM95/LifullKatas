package MarsRover.Decorator;

public class MarsRoversForwardDecorator extends MarsRoverDecorator {
    public MarsRoversForwardDecorator(MarsRover marsRover) {
        super(marsRover);
    }

    @Override
    public void moveForward() {
        super.moveForward();
        super.moveForward();
    }
}
