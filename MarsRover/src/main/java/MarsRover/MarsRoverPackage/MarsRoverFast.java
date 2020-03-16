package MarsRover.MarsRoverPackage;

import MarsRover.Cardinal.Cardinal;
import MarsRover.Coordinates;

import java.util.Objects;

public class MarsRoverFast extends AbstractMarsRover {
    private static final int MARS_ROVER_FAST_VELOCITY = 2;


    public MarsRoverFast(Coordinates coordinates, Cardinal orientation) {

        super(new Coordinates(coordinates, MARS_ROVER_FAST_VELOCITY), orientation);
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
