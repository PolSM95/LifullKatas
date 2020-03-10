package MarsRover.Command;

import MarsRover.Position;
import MarsRover.PossibleChars;

public abstract class CommandFactory {
    public static Command createCommand(Character commandInput, Position position){
        Command command = null;

        if(commandInput == PossibleChars.FORWARD.getValue()){
            command = new ForwardCommand(position);
        }
        if(commandInput == PossibleChars.BACKWARDS.getValue()){
            command = new BackwardCommand(position);
        }
        if(commandInput == PossibleChars.LEFT.getValue()){
            command = new LeftCommand(position);
        }
        if(commandInput == PossibleChars.RIGHT.getValue()){
            command = new RightCommand(position);
        }

        return command;
    }
}
