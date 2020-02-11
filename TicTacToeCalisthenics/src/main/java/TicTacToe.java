
public class TicTacToe {

    private Player lastMove = Player.charO;
    private Board board = new Board();

    public OutputMessage putPosition(Position position) {
        if(lastMove == Player.charO){
            lastMove = Player.charX;
            OutputMessage message = board.addMove(position, lastMove);
            return message;
        }
        lastMove = Player.charO;
        OutputMessage message = board.addMove(position, lastMove);
        return message;
    }
}
