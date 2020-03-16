
import MarsRover.*;
import MarsRover.Cardinal.*;
import MarsRover.MarsRoverPackage.MarsRover;
import MarsRover.MarsRoverPackage.MarsRoverFast;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverBaseShould {

    @ParameterizedTest
    @CsvSource({
            "L,2 3 N,2 3 E",
            "R,2 3 S,2 3 E",
            "R,2 3 N,2 3 W",
            "L,2 3 S,2 3 W",
            "R,2 3 W,2 3 S",
            "L,2 3 E,2 3 S",
            "R,2 3 E,2 3 N",
            "L,2 3 W,2 3 N",
            "F,2 4 N,2 3 N",
            "B,2 2 N,2 3 N",
            "F,3 2 E,2 2 E",
            "B,1 2 E,2 2 E",
            "F,2 1 S,2 2 S",
            "B,2 3 S,2 2 S",
            "F,1 2 W,2 2 W",
            "B,3 2 W,2 2 W",
            "FFLF,0 1 S,2 2 W",
            "F,0 0 E,20 0 E",
            "F,0 0 N,0 20 N",
            "FLFBBBBLF,0 10 S,18 10 N"
    }

    )
    public void generic_test(String command, String expectedPosition, String initialPosition){
        String roverType = "Base";
        MarsRoverController marsRoverController = new MarsRoverController(parsePosition(initialPosition, roverType));
        MarsRoverController marsRoverControllerExpected = new MarsRoverController(parsePosition(expectedPosition, roverType));
        String commandArray =command;

        marsRoverController.inputCommand(commandArray);

        assertEquals(marsRoverControllerExpected, marsRoverController);
    }

    @ParameterizedTest
    @CsvSource({
            "L,2 3 N,2 3 E",
            "R,2 3 S,2 3 E",
            "R,2 3 N,2 3 W",
            "L,2 3 S,2 3 W",
            "R,2 3 W,2 3 S",
            "L,2 3 E,2 3 S",
            "R,2 3 E,2 3 N",
            "L,2 3 W,2 3 N",
            "F,2 5 N,2 3 N",
            "B,2 1 N,2 3 N",
            "F,4 2 E,2 2 E",
            "B,0 2 E,2 2 E",
            "F,2 0 S,2 2 S",
            "B,2 4 S,2 2 S",
            "F,0 2 W,2 2 W",
            "B,4 2 W,2 2 W",
            "F,1 0 E,20 0 E",
            "F,0 1 N,0 20 N"
    }

    )
    public void fast_rover_test(String command, String expectedPosition, String initialPosition){
        String roverType = "Fast";
        MarsRoverController marsRoverController = new MarsRoverController(parsePosition(initialPosition, roverType));
        MarsRoverController marsRoverControllerExpected = new MarsRoverController(parsePosition(expectedPosition, roverType));
        String commandArray =command;

        marsRoverController.inputCommand(commandArray);

        assertEquals(marsRoverControllerExpected, marsRoverController);
    }

    private MarsRover parsePosition(String expectedPosition, String roverType){
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

        if(roverType.equals("Fast")){
            return new MarsRoverFast(coordinates,cardinal);
        }
        if(roverType.equals("Lunar")){
            return new LunarAdapter(coordinates,cardinal);
        }
        return new MarsRoverBase(coordinates, cardinal);
    }

    @ParameterizedTest
    @CsvSource({
            "L,2 3 N,2 3 E",
            "R,2 3 S,2 3 E",
            "R,2 3 N,2 3 W",
            "L,2 3 S,2 3 W",
            "R,2 3 W,2 3 S",
            "L,2 3 E,2 3 S",
            "R,2 3 E,2 3 N",
            "L,2 3 W,2 3 N",
            "F,2 4 N,2 3 N",
            "B,2 2 N,2 3 N",
            "F,3 2 E,2 2 E",
            "B,1 2 E,2 2 E",
            "F,2 1 S,2 2 S",
            "B,2 3 S,2 2 S",
            "F,1 2 W,2 2 W",
            "B,3 2 W,2 2 W",
            "FFLF,0 1 S,2 2 W",
            "F,0 0 E,20 0 E",
            "F,0 0 N,0 20 N",
            "FLFBBBBLF,0 10 S,18 10 N"
    }

    )
    public void lunar_test(String command, String expectedPosition, String initialPosition){
        String roverType = "Base";
        MarsRoverController marsRoverController = new MarsRoverController(parsePosition(initialPosition, roverType));
        MarsRoverController marsRoverControllerExpected = new MarsRoverController(parsePosition(expectedPosition, roverType));
        String commandArray =command;

        marsRoverController.inputCommand(commandArray);

        assertEquals(marsRoverControllerExpected, marsRoverController);
    }



}
