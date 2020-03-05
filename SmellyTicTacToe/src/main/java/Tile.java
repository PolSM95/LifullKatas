import java.util.Objects;

public class Tile
{
    public int xCoordinate;
    public int yCoordinate;
    public char symbol;

    public Tile(int xCoordinate, int yCoordinate, char symbol) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.symbol = symbol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return xCoordinate == tile.xCoordinate &&
                yCoordinate == tile.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean hasSameSymbol(Tile tile){
        return symbol == tile.symbol;

    }
}