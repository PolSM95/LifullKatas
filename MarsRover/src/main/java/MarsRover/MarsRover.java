package MarsRover;

import MarsRover.Cardinal.Cardinal;

import java.util.Objects;

public class MarsRover {
    private  Coordinates coordinates;
    Cardinal orientation;


    public MarsRover(Coordinates coordinates, Cardinal orientation) {

        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public void rotateRight() {
        orientation = orientation.rotateRight();
    }

    public void rotateLeft() {
        orientation = orientation.rotateLeft();
    }

    public void moveBackwards() {
        orientation.moveBackwards(coordinates);
    }

    public void moveForward() {
        orientation.moveForward(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover that = (MarsRover) o;
        return coordinates.xCoordinate == that.coordinates.xCoordinate &&
                coordinates.yCoordinate == that.coordinates.yCoordinate &&
                orientation.getClass() == that.orientation.getClass();

    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates.xCoordinate, coordinates.yCoordinate, orientation);
    }
}