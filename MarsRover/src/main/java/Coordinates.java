import java.util.Objects;

public class Coordinates {
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private int xCoordinate;
    private int yCoordinate;
    char orientation;

    public Coordinates(int xCoordinate, int yCoordinate, char orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    void updateOrientation(char[] commandArray) {

        switch (orientation) {
            case EAST:
                if (commandArray[0] == LEFT) {
                    this.orientation = NORTH;
                }
                if (commandArray[0] == RIGHT) {
                    this.orientation = SOUTH;
                }
                break;
            case WEST:
                if (commandArray[0] == LEFT) {
                    this.orientation = SOUTH;
                }
                if (commandArray[0] == RIGHT) {
                    this.orientation = NORTH;
                }
                break;
            case 'S':
                if (commandArray[0] == LEFT) {
                    this.orientation = EAST;
                }
                if (commandArray[0] == RIGHT) {
                    this.orientation = WEST;
                }

                break;
            case NORTH:
                if (commandArray[0] == LEFT) {
                    this.orientation = WEST;
                }
                if (commandArray[0] == RIGHT) {
                    this.orientation = EAST;
                }

                break;


        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return xCoordinate == that.xCoordinate &&
                yCoordinate == that.yCoordinate &&
                orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, orientation);
    }
}