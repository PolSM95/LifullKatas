public class Board {
    char[][] board = {{' ', ' ',' '} , {' ', ' ',' '} , {' ', ' ',' '}};

    public OutputMessage addMove(Position position, char lastMove) {
        if(board[position.row][position.column] == ' '){
            board[position.row][position.column] = lastMove;
            return messageTurn(lastMove);
        }
        return OutputMessage.taken;
    }

    private OutputMessage messageTurn(char lastMove) {
        if(lastMove == 'o'){
            return OutputMessage.turnX;
        }
        return OutputMessage.turnO;
    }
}
