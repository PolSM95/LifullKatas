public class Tictactoe {

    char lastMove = 'o';
    char[][] board = {{' ', ' ',' '} , {' ', ' ',' '} , {' ', ' ',' '}};


    public char alternateMove() {
        if (lastMove == 'o'){
            lastMove = 'x';
        } else {
            lastMove = 'o';
        }
        return lastMove;
    }


    public boolean makeMove(int[] position) {
        int row = position[0];
        int column = position[1];

        if ((board[row][column]) == ' '){
            alternateMove();
            board[row][column] = lastMove;
            return true;
        }
        return false;
    }
}
