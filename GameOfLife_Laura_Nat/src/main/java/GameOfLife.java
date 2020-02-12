import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class GameOfLife {
    private ArrayList<Seed> next = new ArrayList<>();

    public void life(ArrayList<Seed> actual) {
        if (actual.size() <= 2) {
            next.clear();
        }
        for (Seed seed : actual) {
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameOfLife that = (GameOfLife) o;
        return Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }
}
