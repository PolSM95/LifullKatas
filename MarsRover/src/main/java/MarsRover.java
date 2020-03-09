import java.util.Objects;

public class MarsRover {

    private final Orientation orientation = new Orientation();
    private int xCoordinate;
    private int yCoordinate;


    public MarsRover(int xCoordinate, int yCoordinate, char orientation) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation.orientation = orientation;
    }

    public void inputCommand(char[] commandArray) {
        orientation.updateOrientation(commandArray);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return xCoordinate == marsRover.xCoordinate &&
                yCoordinate == marsRover.yCoordinate &&
                orientation.orientation == marsRover.orientation.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, orientation.orientation);
    }
}
