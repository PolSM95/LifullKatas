import java.util.Objects;

public class MarsRover {

    private int xCoordinate;
    private int yCoordinate;
    private char orientation;


    public MarsRover(int xCoordinate, int yCoordinate, char orientation) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    public void inputCommand(char[] commandArray) {
        if(orientation == 'E'){
            if(commandArray[0] == 'L') {
                this.orientation = 'N';
            }
            if(commandArray[0] == 'R'){
                this.orientation = 'S';
            }
        }

        if(orientation == 'W'){
            if(commandArray[0] == 'L') {
                this.orientation = 'S';
            }
            if(commandArray[0] == 'R'){
                this.orientation = 'N';
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return xCoordinate == marsRover.xCoordinate &&
                yCoordinate == marsRover.yCoordinate &&
                orientation == marsRover.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, orientation);
    }
}
