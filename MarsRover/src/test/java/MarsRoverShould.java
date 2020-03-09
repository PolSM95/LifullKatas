import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_E() {

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.EAST));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.NORTH));
        char[] commandArray = {PossibleChars.LEFT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_E(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.EAST));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.SOUTH));
        char[] commandArray = {PossibleChars.RIGHT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.WEST));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.NORTH));
        char[] commandArray = {PossibleChars.RIGHT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.WEST));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.SOUTH));
        char[] commandArray = {PossibleChars.LEFT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.SOUTH));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.WEST));
        char[] commandArray = {PossibleChars.RIGHT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.SOUTH));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.EAST));
        char[] commandArray = {PossibleChars.LEFT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.NORTH));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2, 3, PossibleChars.EAST));
        char[] commandArray = {PossibleChars.RIGHT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Coordinates(2, 3, PossibleChars.NORTH));
        MarsRover marsRoverExpected = new MarsRover(new Coordinates(2,3,PossibleChars.WEST));
        char[] commandArray = {PossibleChars.LEFT.getValue()};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }



}
