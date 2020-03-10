import java.util.Objects;

public class MarsRover {

    private Position position;

    public MarsRover(Position position) {

        this.position = position;
    }

    public void inputCommand(PossibleChars[] commandArray) {
        position.updatePosition(commandArray);
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
