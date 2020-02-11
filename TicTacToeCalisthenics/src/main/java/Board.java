import java.util.ArrayList;
import java.util.List;

public class Board {
    char[][] board = {{' ', ' ',' '} , {' ', ' ',' '} , {' ', ' ',' '}};


    public OutputMessage addMove(Position position, char lastMove) {
        if(board[position.row][position.column] == ' '){
            board[position.row][position.column] = lastMove;
            return messageTurn(position, lastMove);
        }
        return OutputMessage.taken;
    }

    private OutputMessage messageTurn(Position position, char lastMove) {
        if(winnerHorizontal(position)){
            return OutputMessage.win;
        }
        if(isFull()){
            return OutputMessage.draw;
        }
        if(lastMove == 'o'){
            return OutputMessage.turnX;
        }
        return OutputMessage.turnO;
    }

    private boolean isFull() {

        List <Character> listBoard = new ArrayList<>();
        for(int indexRow = 0; indexRow < 3; indexRow++){
            listBoard.add(board[indexRow][0]);
            listBoard.add(board[indexRow][1]);
            listBoard.add(board[indexRow][2]);
        }
        return !listBoard.contains(' ');
    }

    private boolean winnerHorizontal(Position position) {

        List <Character> listBoard = new ArrayList<>();
        listBoard.add(board[position.row][0]);
        listBoard.add(board[position.row][1]);
        listBoard.add(board[position.row][2]);
        //listBoard.stream().distinct().count();
        if(listBoard.contains(' ')){
            return false;
        }
        return !( listBoard.contains('o') && listBoard.contains('x'));
    }
}
