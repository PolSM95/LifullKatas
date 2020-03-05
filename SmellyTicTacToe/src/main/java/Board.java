import java.util.ArrayList;
import java.util.List;

public class Board
{
    private static final char SYMBOL_DEFAULT = ' ';
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

    public Tile tileAt(int xCoordinate, int yCoordinate)
    {
        for (Tile tile : plays) {
            if (tile.equals(new Tile(xCoordinate,yCoordinate,SYMBOL_DEFAULT))){
                return tile;
            }
        }
        return null;
    }

    public void addTileAt(char symbol, int xCoordinate, int yCoordinate)
    {
        Tile newTile = new Tile(xCoordinate,yCoordinate,symbol);
        tileAt(xCoordinate,yCoordinate).symbol = symbol;
    }

    public char winner() {
        //if the positions in first row are taken
        if (tileAt(0, 0).symbol != ' ' &&
                tileAt(0, 1).symbol != ' ' &&
                tileAt(0, 2).symbol != ' ') {
            //if first row is full with same symbol
            if (tileAt(0, 0).symbol ==
                    tileAt(0, 1).symbol &&
                    tileAt(0, 2).symbol == tileAt(0, 1).symbol) {
                return tileAt(0, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (tileAt(1, 0).symbol != ' ' &&
                tileAt(1, 1).symbol != ' ' &&
                tileAt(1, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (tileAt(1, 0).symbol ==
                    tileAt(1, 1).symbol &&
                    tileAt(1, 2).symbol ==
                            tileAt(1, 1).symbol) {
                return tileAt(1, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (tileAt(2, 0).symbol != ' ' &&
                tileAt(2, 1).symbol != ' ' &&
                tileAt(2, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (tileAt(2, 0).symbol ==
                    tileAt(2, 1).symbol &&
                    tileAt(2, 2).symbol ==
                            tileAt(2, 1).symbol) {
                return tileAt(2, 0).symbol;
            }
        }

        return SYMBOL_DEFAULT;
    }
}