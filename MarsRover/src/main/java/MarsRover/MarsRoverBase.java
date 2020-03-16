package MarsRover;

import MarsRover.Cardinal.Cardinal;
import MarsRover.MarsRoverPackage.AbstractMarsRover;
import MarsRover.MarsRoverPackage.MarsRover;

import java.util.Objects;

public class MarsRoverBase extends AbstractMarsRover {


    public MarsRoverBase(Coordinates coordinates, Cardinal orientation) {
        super(
                coordinates, orientation
        );


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRoverBase that = (MarsRoverBase) o;
        return coordinates.xCoordinate == that.coordinates.xCoordinate &&
                coordinates.yCoordinate == that.coordinates.yCoordinate &&
                orientation.getClass() == that.orientation.getClass();

    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates.xCoordinate, coordinates.yCoordinate, orientation);
    }
}