package MarsRover.MarsRoverPackage;

import MarsRover.Cardinal.Cardinal;
import MarsRover.Coordinates;

import java.util.Objects;

public class MarsRoverFast implements MarsRover {
    private static final int MARS_ROVER_FAST_VELOCITY = 2;
    private Coordinates coordinates;
    private Cardinal orientation;

    public MarsRoverFast(Coordinates coordinates, Cardinal orientation) {
        this.coordinates = new Coordinates(coordinates, MARS_ROVER_FAST_VELOCITY);
        this.orientation = orientation;
    }

    @Override
    public void moveForward() {
        orientation.moveForward(coordinates);
    }

    @Override
    public void moveBackwards() {
        orientation.moveBackwards(coordinates);
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.rotateLeft();
    }

    @Override
    public void rotateRight() {
        orientation = orientation.rotateRight();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRoverFast that = (MarsRoverFast) o;
        return coordinates.xCoordinate == that.coordinates.xCoordinate &&
                coordinates.yCoordinate == that.coordinates.yCoordinate &&
                orientation.getClass() == that.orientation.getClass();

    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, orientation);
    }
}
