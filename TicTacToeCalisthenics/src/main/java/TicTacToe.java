
public class TicTacToe {

    private char lastMove = 'o';
    private Board board = new Board();


    public OutputMessage putPosition(Position position) {
        if(lastMove == 'o'){
            lastMove = 'x';
            OutputMessage message = board.addMove(position, lastMove);
            return message;
        }
        lastMove = 'o';
        OutputMessage message = board.addMove(position, lastMove);
        return message;
    }

}
