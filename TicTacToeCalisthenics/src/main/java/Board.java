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
        if(isFull()){
            return OutputMessage.draw;
        }
        if(lastMove == 'o'){
            return OutputMessage.turnX;
        }
        return OutputMessage.turnO;
    }

    private boolean isFull() {
        for(int indexRow = 0; indexRow < 3; indexRow++){
            if(board[indexRow][0] == ' ' || board[indexRow][1] == ' ' || board[indexRow][2] == ' ') return false;
        }
        return true;
    }
}
