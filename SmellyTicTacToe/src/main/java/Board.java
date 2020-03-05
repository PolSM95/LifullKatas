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

    private boolean checkRowIfSomeoneWIN(int rowIndex) {
        if (checkIfRowIsNotEmpty(rowIndex)) {
            return checkIfAllRowHasSameSymbol(rowIndex);
        }
        return false;
    }

    public char winner() {
        if (this.checkRowIfSomeoneWIN(0)) return tileAt(new Tile(0, 0, SYMBOL_DEFAULT)).getSymbol();
        if (this.checkRowIfSomeoneWIN(1)) return tileAt(new Tile(1, 0, SYMBOL_DEFAULT)).getSymbol();
        if (this.checkRowIfSomeoneWIN(2)) return tileAt(new Tile(2, 0, SYMBOL_DEFAULT)).getSymbol();
        return SYMBOL_DEFAULT;
    }

    public Tile tileAt(Tile tile)
    {
        if (plays.contains(tile)) {

            return plays.get(plays.indexOf(tile));
        }

        return null;
    }

    public void updateTileAt(char symbol, int xCoordinate, int yCoordinate)
    {
        Tile tile = new Tile(xCoordinate, yCoordinate, symbol);
        plays.set(plays.indexOf(tile), tile);
    }

    private boolean checkIfAllRowHasSameSymbol(int rowIndex) {
        return tileAt(new Tile(rowIndex, 0, SYMBOL_DEFAULT)).hasSameSymbol(tileAt(new Tile(rowIndex, 1, SYMBOL_DEFAULT))) &&
                tileAt(new Tile(rowIndex, 2, SYMBOL_DEFAULT)).hasSameSymbol(tileAt(new Tile(rowIndex, 1, SYMBOL_DEFAULT)));
    }

    private boolean checkIfRowIsNotEmpty(int rowIndex) {
        return !tileAt(new Tile(rowIndex, 0, SYMBOL_DEFAULT)).hasSameSymbol(new Tile(rowIndex, 1, SYMBOL_DEFAULT)) &&
                !tileAt(new Tile(rowIndex, 2, SYMBOL_DEFAULT)).hasSameSymbol(new Tile(rowIndex, 1, SYMBOL_DEFAULT));
    }
}