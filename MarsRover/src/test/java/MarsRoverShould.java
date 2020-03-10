import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_E() {

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new East()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new North()));
        PossibleChars[] commandArray = {PossibleChars.LEFT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_E(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new East()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new South()));
        PossibleChars[] commandArray = {PossibleChars.RIGHT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new West()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new North()));
        PossibleChars[] commandArray = {PossibleChars.RIGHT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new West()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new South()));
        PossibleChars[] commandArray = {PossibleChars.LEFT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new South()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new West()));
        PossibleChars[] commandArray = {PossibleChars.RIGHT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new South()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new East()));
        PossibleChars[] commandArray = {PossibleChars.LEFT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new North()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new East()));
        PossibleChars[] commandArray = {PossibleChars.RIGHT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new North()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3),new West()));
        PossibleChars[] commandArray = {PossibleChars.LEFT};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_N(){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,4),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new North()));
        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }



}
