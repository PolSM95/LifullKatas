package MarsRover.Command;

import MarsRover.Position;
import MarsRover.PossibleChars;

public abstract class CommandFactory {
    public static Command createCommand(PossibleChars commandInput, Position position){
        Command command = null;

        if(commandInput == PossibleChars.FORWARD){
            command = new ForwardCommand(position);
        }
        if(commandInput == PossibleChars.BACKWARDS){
            command = new BackwardCommand(position);
        }
        if(commandInput == PossibleChars.LEFT){
            command = new LeftCommand(position);
        }
        if(commandInput == PossibleChars.RIGHT){
            command = new RightCommand(position);
        }

        return command;
    }
}
