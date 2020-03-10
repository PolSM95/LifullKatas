package MarsRover;

import MarsRover.Command.*;

import java.util.Objects;

public class MarsRover {

    private Position position;

    public MarsRover(Position position) {

        this.position = position;
    }


    void updatePosition(Character commandInput) {
        Command command = CommandFactory.createCommand(commandInput, position);
        command.execute();
    }

    public void inputCommand(String commandArray) {

        for (Character order :commandArray.toCharArray() ) {
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
