public class Tictactoe {

    String lastMove = "o";
    char[][] board = {{' ', ' ',' '} , {' ', ' ',' '} , {' ', ' ',' '}};


    public String makeMove() {
        if (lastMove.equals("o")){
            lastMove = "x";
        } else {
            lastMove = "o";
        }
        return lastMove;
    }


    public boolean checkPosition(int[] position) {
        int row = position[0];
        int column = position[1];

        if ((board[row][column]) == ' '){
            board[row][column] = 'x';
            return true;
        }
        return false;
    }
}
