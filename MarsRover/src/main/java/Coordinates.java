import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    Cardinal orientation;


    public Coordinates(int xCoordinate, int yCoordinate, Cardinal orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    void updatePosition(PossibleChars[] commandArray) {

        if(commandArray[0] == PossibleChars.FORWARD){
            orientation.moveForward();
        }
        if(commandArray[0] == PossibleChars.BACKWARDS){
            orientation.moveBackwards();
        }
        if(commandArray[0] == PossibleChars.LEFT){
            orientation.rotateLeft();
        }
        if(commandArray[0] == PossibleChars.RIGHT){
            orientation.rotateRight();
        }

    }

}