public class Tictactoe {

    char lastMove = 'o';
    char[][] board = {{' ', ' ',' '} , {' ', ' ',' '} , {' ', ' ',' '}};
    int row;
    int column;

    public char alternateMove() {
        if (lastMove == 'o'){
            lastMove = 'x';
        } else {
            lastMove = 'o';
        }
        return lastMove;
    }


    public boolean makeMove(int[] position) {
        row = position[0];
        column = position[1];

        if ((board[row][column]) == ' '){
            alternateMove();
            board[row][column] = lastMove;
            return true;
        }
        return false;
    }

    public boolean checkBoard() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    isFull = false;
                }
            }
        }
        return isFull;
    }
}
