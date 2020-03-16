package MarsRover.Command;

import MarsRover.MarsRoverBase;
import MarsRover.PossibleChars;

public abstract class CommandFactory {
    public static Command createCommand(Character commandInput, MarsRoverBase marsRover){
        Command command = null;

        if(commandInput == PossibleChars.FORWARD.getValue()){
            command = new ForwardCommand(marsRover);
        }
        if(commandInput == PossibleChars.BACKWARDS.getValue()){
            command = new BackwardCommand(marsRover);
        }
        if(commandInput == PossibleChars.LEFT.getValue()){
            command = new LeftCommand(marsRover);
        }
        if(commandInput == PossibleChars.RIGHT.getValue()){
            command = new RightCommand(marsRover);
        }

        return command;
    }
}
