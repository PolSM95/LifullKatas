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

    void updateOrientation(PossibleChars[] commandArray) {

        rotation(commandArray[0]);

    }

    public void rotation(PossibleChars direction){

        int currentDirection = cardinals.indexOf(orientation);

        if(direction == PossibleChars.LEFT){
            currentDirection --;
            if(currentDirection < 0 ){
                currentDirection = 3;
            }
        }
        else if (direction == PossibleChars.RIGHT){
            currentDirection ++;
            if(currentDirection > 3){
                currentDirection = 0;
            }
        }

        orientation = cardinals.get(currentDirection);

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