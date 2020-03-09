import java.util.Objects;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    PossibleChars orientation;

    public Coordinates(int xCoordinate, int yCoordinate, PossibleChars orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    void updateOrientation(char[] commandArray) {


        switch (orientation) {
            case EAST:
                if (commandArray[0] == PossibleChars.LEFT.getValue()) {
                    this.orientation = PossibleChars.NORTH;
                }
                if (commandArray[0] == PossibleChars.RIGHT.getValue()) {
                    this.orientation = PossibleChars.SOUTH;
                }
                break;
            case WEST:
                if (commandArray[0] == PossibleChars.LEFT.getValue()) {
                    this.orientation = PossibleChars.SOUTH;
                }
                if (commandArray[0] == PossibleChars.RIGHT.getValue()) {
                    this.orientation = PossibleChars.NORTH;
                }
                break;
            case SOUTH:
                if (commandArray[0] == PossibleChars.LEFT.getValue()) {
                    this.orientation = PossibleChars.EAST;
                }
                if (commandArray[0] == PossibleChars.RIGHT.getValue()) {
                    this.orientation = PossibleChars.WEST;
                }

                break;
            case NORTH:
                if (commandArray[0] == PossibleChars.LEFT.getValue()) {
                    this.orientation = PossibleChars.WEST;
                }
                if (commandArray[0] == PossibleChars.RIGHT.getValue()) {
                    this.orientation = PossibleChars.EAST;
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
        return Objects.hash(xCoordinate, yCoordinate, orientation.getValue());
    }
}