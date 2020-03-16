package MarsRover;
import java.util.Objects;

public class LunarRover {

    private int xPos;
    private int yPos;

    public LunarRover(int xPos, int yPos) {

        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void moveLeft() {
        xPos--;
    }

    public void moveRight() {
        xPos++;
    }

    public void moveUp() {
        yPos++;
    }

    public void moveDown() {
        yPos--;
    }

    @Override
    public String toString() {
        return xPos + " " + yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunarRover that = (LunarRover) o;
        return xPos == that.xPos &&
                yPos == that.yPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPos, yPos);
    }
}
