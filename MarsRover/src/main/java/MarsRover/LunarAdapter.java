package MarsRover;

import MarsRover.Cardinal.*;
import MarsRover.MarsRoverPackage.BasicMarsRover;

import java.util.Objects;

public class LunarAdapter extends BasicMarsRover {

    private LunarRover lunarRover;

    public LunarAdapter(int xCoordinate, int yCoordinate, Cardinal orientation) {
        super(null, orientation);
        lunarRover = new LunarRover(xCoordinate, yCoordinate);
    }

    @Override
    public void moveForward() {
        if(orientation instanceof North){
            lunarRover.moveUp();
        }
        if (orientation instanceof South){
            lunarRover.moveDown();
        }
        if (orientation instanceof West){
            lunarRover.moveLeft();
        }
        if (orientation instanceof East){
            lunarRover.moveRight();
        }

    }

    @Override
    public void moveBackwards() {
        if(orientation instanceof North){
            lunarRover.moveDown();
        }
        if (orientation instanceof South){
            lunarRover.moveUp();
        }
        if (orientation instanceof West){
            lunarRover.moveRight();
        }
        if (orientation instanceof East){
            lunarRover.moveLeft();
        }
    }

    @Override
    public void rotateLeft() {
        orientation.rotateLeft();
    }

    @Override
    public void rotateRight() {
        orientation.rotateRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunarAdapter that = (LunarAdapter) o;
        return Objects.equals(lunarRover, that.lunarRover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, lunarRover);
    }
}
