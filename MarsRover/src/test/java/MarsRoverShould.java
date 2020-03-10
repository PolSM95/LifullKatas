
import MarsRover.*;
import MarsRover.Cardinal.East;
import MarsRover.Cardinal.North;
import MarsRover.Cardinal.South;
import MarsRover.Cardinal.West;
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

    @Test
    public void move_backwards_when_input_command_is_B_and_initial_orientation_is_N (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,2),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new North()));

        PossibleChars[] commandArray = {PossibleChars.BACKWARDS};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_E (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(3,2),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new East()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_E (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(1,2),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new East()));

        PossibleChars[] commandArray = {PossibleChars.BACKWARDS};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_S (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,1),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new South()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_S (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new South()));

        PossibleChars[] commandArray = {PossibleChars.BACKWARDS};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_W (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(1,2),new West()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_W (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(3,2),new West()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        PossibleChars[] commandArray = {PossibleChars.BACKWARDS};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }


    @Test
    public void update_position_when_sending_multiple_commands(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,1),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD,PossibleChars.FORWARD,PossibleChars.LEFT, PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

        }

    @Test
    public void check_position_when_exceeding_x_coordinate_limit(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,0),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(20,0),new East()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

    }

    @Test
    public void check_position_when_exceeding_y_coordinate_limit(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,0),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(0,20),new North()));

        PossibleChars[] commandArray = {PossibleChars.FORWARD};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

    }

    @Test
    public void checking_that_everything_works_by_introducing_very_long_command(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,10),new South()));
        MarsRover marsRover = new MarsRover((new Position(new Coordinates(18,10), new North())));

        PossibleChars[] commandArray = {PossibleChars.FORWARD,PossibleChars.LEFT,PossibleChars.FORWARD, PossibleChars.BACKWARDS,PossibleChars.BACKWARDS, PossibleChars.BACKWARDS,PossibleChars.BACKWARDS,PossibleChars.LEFT,PossibleChars.FORWARD};
        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected,marsRover);
     }


}
