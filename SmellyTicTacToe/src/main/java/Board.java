import java.util.ArrayList;
import java.util.List;

public class Board
{
    public static final char SYMBOL_DEFAULT = ' ';
    private List<Tile> plays = new ArrayList<>();

    public Board()
    {
        for (int xCoordinate = 0; xCoordinate < 3; xCoordinate++)
        {
            for (int yCoordinate = 0; yCoordinate < 3; yCoordinate++)
            {
                Tile tile = new Tile(xCoordinate,yCoordinate,SYMBOL_DEFAULT);
                plays.add(tile);
            }
        }
    }

    public Tile tileAt(Tile tile)
    {
        for (Tile currentTile : plays) {
            if (currentTile.equals(tile)){
                return currentTile;
            }
        }
        return null;
    }

    public void updateTileAt(char symbol, int xCoordinate, int yCoordinate)
    {
        Tile tile = new Tile(xCoordinate, yCoordinate, symbol);
        plays.set(plays.indexOf(tile), tile);
    }

    public static char winner(Board board) {
        if (checkRowIfSomeoneWIN(board, 0)) return board.tileAt(new Tile(0, 0, SYMBOL_DEFAULT)).symbol;
        if (checkRowIfSomeoneWIN(board, 1)) return board.tileAt(new Tile(1, 0, SYMBOL_DEFAULT)).symbol;
        if (checkRowIfSomeoneWIN(board, 2)) return board.tileAt(new Tile(2, 0, SYMBOL_DEFAULT)).symbol;
        return SYMBOL_DEFAULT;
    }

    private static boolean checkRowIfSomeoneWIN(Board board, int rowIndex) {
        if (board.checkIfRowIsNotEmpty(rowIndex)) {
            if (board.checkIfAllRowHasSameSymbol(rowIndex)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfAllRowHasSameSymbol(int rowIndex) {
        return tileAt(new Tile(rowIndex, 0, SYMBOL_DEFAULT)).symbol ==
                tileAt(new Tile(rowIndex, 1, SYMBOL_DEFAULT)).symbol &&
                tileAt(new Tile(rowIndex, 2, SYMBOL_DEFAULT)).symbol == tileAt(new Tile(rowIndex, 1, SYMBOL_DEFAULT)).symbol;
    }

    private boolean checkIfRowIsNotEmpty(int rowIndex) {
        return tileAt(new Tile(rowIndex, 0, SYMBOL_DEFAULT)).symbol != ' ' &&
                tileAt(new Tile(rowIndex, 1, SYMBOL_DEFAULT)).symbol != ' ' &&
                tileAt(new Tile(rowIndex, 2, SYMBOL_DEFAULT)).symbol != ' ';
    }
}