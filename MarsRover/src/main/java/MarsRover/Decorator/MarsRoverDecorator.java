package MarsRover.MarsRoverPackage;

import java.util.Objects;

public abstract class MarsRoverDecorator implements MarsRover{
    private MarsRover marsRover;

    public MarsRoverDecorator (MarsRover marsRover){
        this.marsRover = marsRover;
    }

    @Override
    public void moveForward() {
        marsRover.moveForward();
    }

    @Override
    public void moveBackwards() {
        marsRover.moveBackwards();
    }

    @Override
    public void rotateLeft() {
        marsRover.rotateLeft();
    }

    @Override
    public void rotateRight() {
        marsRover.rotateRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRoverDecorator that = (MarsRoverDecorator) o;
        return Objects.equals(marsRover, that.marsRover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marsRover);
    }
}
