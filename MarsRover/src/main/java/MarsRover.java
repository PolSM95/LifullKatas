import java.util.Objects;

public class MarsRover {

    private Position position;

    public MarsRover(Position position) {

        this.position = position;
    }


    void updatePosition(PossibleChars command) {

        if(command == PossibleChars.FORWARD){
            position.moveForward();
        }
        if(command == PossibleChars.BACKWARDS){
            position.moveBackwards();
        }
        if(command == PossibleChars.LEFT){
            position.rotateLeft();
        }
        if(command == PossibleChars.RIGHT){
            position.rotateRight();
        }

    }

    public void inputCommand(PossibleChars[] commandArray) {
        for (PossibleChars order :commandArray ) {
            updatePosition(order);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return position.equals(marsRover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
