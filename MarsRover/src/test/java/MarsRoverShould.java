
import MarsRover.*;
import MarsRover.Cardinal.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({
            "L,2 3 N",
            "LL,2 3 W"
    }

    )
    public void generic_test(String command, String expectedPosition){
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new East()));
        MarsRover marsRoverExpected = new MarsRover(parsePosition(expectedPosition));
        String commandArray =command;

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    private Position parsePosition(String expectedPosition){
        String[] position = expectedPosition.split(" ");
        Coordinates coordinates = new Coordinates(Integer.parseInt(position[0]), Integer.parseInt(position[1]));
        Cardinal cardinal = new South();
        if(position[2].equals("N")){
            cardinal = new North();
        }
        if(position[2].equals( "W")){
            cardinal = new West();
        }
        if(position[2].equals("E")){
            cardinal = new East();
        }

        return new Position(coordinates, cardinal);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_E() {

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new East()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new North()));
        String commandArray = "L";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_E(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new East()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new South()));
        String commandArray = "R";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new West()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new North()));
        String commandArray = "R";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_W(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new West()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new South()));
        String commandArray = "L";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new South()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new West()));
        String commandArray = "R";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_S(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new South()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new East()));
        String commandArray = "L";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }
    @Test
    public void rotate_right_when_input_command_is_R_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new North()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3), new East()));
        String  commandArray = "R";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_L_and_initial_orientation_is_N(){

        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3), new North()));
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3),new West()));
        String commandArray = "L";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_N(){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,4),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new North()));
        String  commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backwards_when_input_command_is_B_and_initial_orientation_is_N (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,2),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,3),new North()));

        String commandArray = "B";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_E (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(3,2),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new East()));

        String commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_E (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(1,2),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new East()));

        String commandArray = "B";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_S (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,1),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new South()));

        String commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_S (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(2,3),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new South()));

        String commandArray = "B";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_forward_when_input_command_is_F_and_initial_orientation_is_W (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(1,2),new West()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        String commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void move_backward_when_input_command_is_B_and_initial_orientation_is_W (){

        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(3,2),new West()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        String commandArray = "B";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }


    @Test
    public void update_position_when_sending_multiple_commands(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,1),new South()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(2,2),new West()));

        String commandArray = "FFLF";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

        }

    @Test
    public void check_position_when_exceeding_x_coordinate_limit(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,0),new East()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(20,0),new East()));

        String commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

    }

    @Test
    public void check_position_when_exceeding_y_coordinate_limit(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,0),new North()));
        MarsRover marsRover = new MarsRover(new Position(new Coordinates(0,20),new North()));

        String commandArray = "F";

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);

    }

    @Test
    public void checking_that_everything_works_by_introducing_very_long_command(){
        MarsRover marsRoverExpected = new MarsRover(new Position(new Coordinates(0,10),new South()));
        MarsRover marsRover = new MarsRover((new Position(new Coordinates(18,10), new North())));

        String commandArray = "FLFBBBBLF";
        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected,marsRover);
     }


}
