import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Coordinates {

    private int row;
    private int column;

    public Coordinates(int row, int column){
        this.row = row;
        this.column = column;
    }

    public ArrayList<Coordinates> CalculateNeighbour(){

        ArrayList<Coordinates> possibleNeighbours = new ArrayList<>();

        possibleNeighbours.add(new Coordinates(row-1,column-1));
        possibleNeighbours.add(new Coordinates(row,column-1));
        possibleNeighbours.add(new Coordinates(row+1,column-1));
        possibleNeighbours.add(new Coordinates(row-1,column));
        possibleNeighbours.add(new Coordinates(row+1,column));
        possibleNeighbours.add(new Coordinates(row-1,column+1));
        possibleNeighbours.add(new Coordinates(row,column+1));
        possibleNeighbours.add(new Coordinates(row+1,column+1));

        return possibleNeighbours ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
