import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile tile = new Tile();
                tile.x = i;
                tile.y = j;
                tile.symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.x == x && t.y == y){
                return t;
            }
        }
        return null;
    }

    public void addTileAt(char symbol, int x, int y)
    {
        Tile newTile = new Tile();
        newTile.x = x;
        newTile.y = y;
        newTile.symbol = symbol;

        tileAt(x,y).symbol = symbol;
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

        return ' ';
    }
}