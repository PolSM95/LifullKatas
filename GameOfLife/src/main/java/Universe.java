import java.util.ArrayList;
import java.util.Objects;

public class Universe {

    private ArrayList<Cell> listCell = new ArrayList<>();

    public void addCellList(Cell cell){
        listCell.add(cell);
    }

    public void evolve (){
        listCell.clear();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Objects.equals(listCell, universe.listCell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listCell);
    }
}
