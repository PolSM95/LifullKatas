import java.util.Objects;

public class Position {
    private  Coordinates coordinates;
    Cardinal orientation;

    public Position(Coordinates coordinates, Cardinal orientation) {

        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    void updatePosition(PossibleChars[] commandArray) {

        if(commandArray[0] == PossibleChars.FORWARD){
            orientation.moveForward(coordinates);
        }
        if(commandArray[0] == PossibleChars.BACKWARDS){
            orientation.moveBackwards(coordinates);
        }
        if(commandArray[0] == PossibleChars.LEFT){
            orientation = orientation.rotateLeft();
        }
        if(commandArray[0] == PossibleChars.RIGHT){
            orientation = orientation.rotateRight();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return coordinates.xCoordinate == that.coordinates.xCoordinate &&
                coordinates.yCoordinate == that.coordinates.yCoordinate &&
                orientation.getClass() == that.orientation.getClass();

    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates.xCoordinate, coordinates.yCoordinate, orientation);
    }
}