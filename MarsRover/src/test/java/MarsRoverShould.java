import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverShould {

    @Test
    public void rotate_left_when_input_command_is_L(){

        MarsRover marsRover = new MarsRover(2,3,'E');
        MarsRover marsRoverExpected = new MarsRover(2,3,'N');
        char[] commandArray = {'L'};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }

    @Test
    public void rotate_left_when_input_command_is_R(){

        MarsRover marsRover = new MarsRover(2,3,'E');
        MarsRover marsRoverExpected = new MarsRover(2,3,'S');
        char[] commandArray = {'R'};

        marsRover.inputCommand(commandArray);

        assertEquals(marsRoverExpected, marsRover);
    }


}
