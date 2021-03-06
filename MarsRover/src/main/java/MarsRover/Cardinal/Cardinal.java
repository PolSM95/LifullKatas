package MarsRover.Cardinal;

import MarsRover.Coordinates;

public interface Cardinal {
    Cardinal rotateLeft();
    Cardinal rotateRight();
    void moveForward(Coordinates coordinates);
    void moveBackwards(Coordinates coordinates);
}
