import java.util.Objects;

public class MarsRover {

    private int xCoordinate;
    private int yCoordinate;
    private Coordinates coordinates;





    public MarsRover(Coordinates coordinates) {

        this.coordinates = coordinates;
    }

    public void inputCommand(char[] commandArray) {
        coordinates.updateOrientation(commandArray);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return xCoordinate == marsRover.xCoordinate &&
                yCoordinate == marsRover.yCoordinate &&
                coordinates.orientation == marsRover.coordinates.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, coordinates.orientation);
    }
}
