

public interface Cardinal {
    Cardinal rotateLeft();
    Cardinal rotateRight();
    Coordinates moveForward(Coordinates coordinates);
    Coordinates moveBackwards(Coordinates coordinates);
}
