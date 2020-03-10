import java.util.Objects;

public class MarsRover {

    private Position position;

    public MarsRover(Position position) {

        this.position = position;
    }


    void updatePosition(PossibleChars commandInput) {
        Command command = null;

        if(commandInput == PossibleChars.FORWARD){
            command = new ForwardCommand(position);
        }
        if(commandInput == PossibleChars.BACKWARDS){
            command = new BackwardCommand(position);
        }
        if(commandInput == PossibleChars.LEFT){
            command = new LeftCommand(position);
        }
        if(commandInput == PossibleChars.RIGHT){
            command = new RightCommand(position);
        }
        command.execute();
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
