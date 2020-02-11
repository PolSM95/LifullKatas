
public class TicTacToe {

    private char lastMove = 'o';

    public OutputMessage putPosition(Position position) {
        if(lastMove == 'o'){
            lastMove = 'x';
            return OutputMessage.turnO;
        }
        lastMove = 'o';
        return OutputMessage.turnX;
    }
}
