package MarsRover;

import MarsRover.Command.*;

import java.util.Objects;

public class MarsRoverController {

    private MarsRover marsRover;

    public MarsRoverController(MarsRover marsRover) {

        this.marsRover = marsRover;
    }


    void updatePosition(Character commandInput) {
        Command command = CommandFactory.createCommand(commandInput, marsRover);
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
        MarsRoverController marsRoverController = (MarsRoverController) o;
        return marsRover.equals(marsRoverController.marsRover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marsRover);
    }
}
