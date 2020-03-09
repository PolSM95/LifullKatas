import java.util.Objects;

public class MarsRover {

    private Coordinates coordinates;

    public MarsRover(Coordinates coordinates) {

        this.coordinates = coordinates;
    }

    public void inputCommand(PossibleChars[] commandArray) {
        coordinates.updateOrientation(commandArray);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return coordinates.equals(marsRover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
