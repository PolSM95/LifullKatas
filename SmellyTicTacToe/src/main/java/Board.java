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

    public void addTileAt(char symbol, int xCoordinate, int yCoordinate)
    {
        tileAt(new Tile(xCoordinate, yCoordinate, SYMBOL_DEFAULT)).symbol = symbol;
    }

    public char winner() {
        //if the positions in first row are taken
        if (checkIfRowIsNotEmpty(0)) {
            //if first row is full with same symbol
            if (checkIfAllRowHasSameSymbol(0)) {
                return tileAt(new Tile(0, 0, SYMBOL_DEFAULT)).symbol;
            }
        }

        //if the positions in first row are taken
        if (checkIfRowIsNotEmpty(1)) {
            //if middle row is full with same symbol
            if (checkIfAllRowHasSameSymbol(1)) {
                return tileAt(new Tile(1, 0, SYMBOL_DEFAULT)).symbol;
            }
        }

        //if the positions in first row are taken
        if (checkIfRowIsNotEmpty(2)) {
            //if middle row is full with same symbol
            if (checkIfAllRowHasSameSymbol(2)) {
                return tileAt(new Tile(2, 0, SYMBOL_DEFAULT)).symbol;
            }
        }

        return SYMBOL_DEFAULT;
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