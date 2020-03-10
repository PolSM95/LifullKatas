package MarsRover.Cardinal;

import MarsRover.Coordinates;

public class South implements Cardinal {
    @Override
    public Cardinal rotateLeft() {
        return new East();
    }

    @Override
    public Cardinal rotateRight() {
        return new West();
    }

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.moveDown();
    }

    @Override
    public void moveBackwards(Coordinates coordinates) {
        coordinates.moveUp();
    }
}
