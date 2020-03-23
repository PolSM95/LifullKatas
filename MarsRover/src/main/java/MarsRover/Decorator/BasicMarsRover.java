package MarsRover.MarsRoverPackage;

import MarsRover.Cardinal.Cardinal;
import MarsRover.Coordinates;

import java.util.Objects;

public class BasicMarsRover implements MarsRover {
    protected Coordinates coordinates;
    protected Cardinal orientation;

    public BasicMarsRover(Coordinates coordinates, Cardinal orientation) {

        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    @Override
    public void rotateRight() {
        orientation = orientation.rotateRight();
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.rotateLeft();
    }

    @Override
    public void moveBackwards() {
        orientation.moveBackwards(coordinates);
    }

    @Override
    public void moveForward() {
        orientation.moveForward(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicMarsRover that = (BasicMarsRover) o;
        return (coordinates.xCoordinate == that.coordinates.xCoordinate) &&
                (coordinates.yCoordinate == that.coordinates.yCoordinate) &&
                orientation.getClass() == that.orientation.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, orientation);
    }
}
