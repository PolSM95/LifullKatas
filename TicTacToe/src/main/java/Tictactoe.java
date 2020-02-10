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


    public String makeMove(int[] position) {
        row = position[0];
        column = position[1];

        if ((board[row][column]) == ' '){
            alternateMove();
            board[row][column] = lastMove;
            printBoard();
            if(check_if_board_is_full()){
                return "DRAW";
            }
            return "true";
        }
        return "false";
    }

    public boolean check_if_board_is_full() {
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

    public void printBoard(){
        String stringBoard = "";
        stringBoard += "-------------"+"\n";
        for (int i = 0; i < 3; i++){
            stringBoard += "| ";
            for (int j = 0; j < 3; j++){
                stringBoard += board[i][j] + " | ";
            }
            stringBoard += "\n";
            stringBoard += "-------------"+"\n";
        }
        System.out.println(stringBoard);
    }
}
