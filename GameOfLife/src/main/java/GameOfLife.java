import java.util.ArrayList;
import java.util.Objects;

public class GameOfLife {

    Universe universe = new Universe();

    public void addCell(Cell cell) {
        universe.addCellList(cell);
    }

    public void nextRound() {
        universe.evolve();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameOfLife that = (GameOfLife) o;
        return Objects.equals(universe, that.universe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universe);
    }
}
