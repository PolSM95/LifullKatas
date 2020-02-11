import java.util.ArrayList;
import java.util.List;

public class Board {
    Player[][] board = {{Player.charEmpty, Player.charEmpty, Player.charEmpty}, {Player.charEmpty, Player.charEmpty, Player.charEmpty}, {Player.charEmpty, Player.charEmpty, Player.charEmpty}};

    public OutputMessage addMove(Position position, Player lastMove) {
        if (board[position.row][position.column] == Player.charEmpty) {
            board[position.row][position.column] = lastMove;
            return messageTurn(position, lastMove);
        }
        return OutputMessage.taken;
    }

    private OutputMessage messageTurn(Position position, Player lastMove) {
        if (winnerHorizontal(position) || winnerVertical(position)) {
            return OutputMessage.win;
        }
        if (isFull()) {
            return OutputMessage.draw;
        }
        if (lastMove == Player.charO) {
            return OutputMessage.turnX;
        }
        return OutputMessage.turnO;
    }

    private boolean isFull() {
        List<Player> listBoard = new ArrayList<>();
        for (int indexRow = 0; indexRow < 3; indexRow++) {
            listBoard.add(board[indexRow][0]);
            listBoard.add(board[indexRow][1]);
            listBoard.add(board[indexRow][2]);
        }
        return !listBoard.contains(Player.charEmpty);
    }

    private boolean winnerHorizontal(Position position) {
        List<Player> listBoard = new ArrayList<>();
        listBoard.add(board[position.row][0]);
        listBoard.add(board[position.row][1]);
        listBoard.add(board[position.row][2]);
        if (listBoard.contains(Player.charEmpty)) {
            return false;
        }
        return !(listBoard.contains(Player.charO) && listBoard.contains(Player.charX));
    }

    private boolean winnerVertical(Position position) {
        List<Player> listBoard = new ArrayList<>();
        listBoard.add(board[0][position.column]);
        listBoard.add(board[1][position.column]);
        listBoard.add(board[2][position.column]);
        if (listBoard.contains(Player.charEmpty)) {
            return false;
        }
        return !(listBoard.contains(Player.charO) && listBoard.contains(Player.charX));
    }
}

