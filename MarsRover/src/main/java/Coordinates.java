import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    PossibleChars orientation;
    private List<PossibleChars> cardinals = new ArrayList();

    public Coordinates(int xCoordinate, int yCoordinate, PossibleChars orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
        cardinals.addAll(Arrays.asList(new PossibleChars[]{PossibleChars.NORTH, PossibleChars.EAST, PossibleChars.SOUTH, PossibleChars.WEST}));

    }

    void updatePosition(PossibleChars[] commandArray) {

        if(commandArray[0] == PossibleChars.FORWARD){
            move(commandArray[0]);
        }
        else {
            rotation(commandArray[0]);
        }

    }

    private void move(PossibleChars direction) {
        if (orientation == PossibleChars.NORTH){
            if (direction == PossibleChars.FORWARD){
                yCoordinate++;
            }
            if (direction == PossibleChars.BACKWARDS){
                yCoordinate--;
            }
        }
        if (orientation == PossibleChars.SOUTH){
            if (direction == PossibleChars.FORWARD){
                yCoordinate--;
            }
            if (direction == PossibleChars.BACKWARDS){
                yCoordinate++;
            }
        }
        if (orientation == PossibleChars.EAST){
            if (direction == PossibleChars.FORWARD){
                xCoordinate++;
            }
            if (direction == PossibleChars.BACKWARDS){
                xCoordinate--;
            }
        }
        if (orientation == PossibleChars.WEST){
            if (direction == PossibleChars.FORWARD){
                xCoordinate--;
            }
            if (direction == PossibleChars.BACKWARDS){
                xCoordinate++;
            }
        }
    }

    public void rotation(PossibleChars direction){

        int currentDirection = cardinals.indexOf(orientation);

        if(direction == PossibleChars.LEFT){
            currentDirection = rotateLeft(currentDirection);
        }
        else if (direction == PossibleChars.RIGHT){
            currentDirection = rotateRight(currentDirection);
        }

        orientation = cardinals.get(currentDirection);

    }

    private int rotateRight(int currentDirection) {
        currentDirection ++;
        if(currentDirection > 3){
            currentDirection = 0;
        }
        return currentDirection;
    }

    private int rotateLeft(int currentDirection) {
        currentDirection --;
        if(currentDirection < 0 ){
            currentDirection = 3;
        }
        return currentDirection;
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