package MarsRover;

import MarsRover.Cardinal.*;
import MarsRover.MarsRoverPackage.AbstractMarsRover;

import java.util.Objects;

public class LunarAdapter extends AbstractMarsRover {

    private Cardinal auxiliarOrientation;
    private LunarRover lunarRover;

    public LunarAdapter(Coordinates coordinates, Cardinal orientation) {
        super(coordinates, orientation);
        auxiliarOrientation = orientation;
        lunarRover = new LunarRover(coordinates.xCoordinate,coordinates.yCoordinate);

    }

    @Override
    public void moveForward() {
        if(auxiliarOrientation instanceof North){
            lunarRover.moveUp();
        }
        if (auxiliarOrientation instanceof South){
            lunarRover.moveDown();
        }
        if (auxiliarOrientation instanceof West){
            lunarRover.moveLeft();
        }
        if (auxiliarOrientation instanceof East){
            lunarRover.moveRight();
        }

    }

    @Override
    public void moveBackwards() {
        if(auxiliarOrientation instanceof North){
            lunarRover.moveDown();
        }
        if (auxiliarOrientation instanceof South){
            lunarRover.moveUp();
        }
        if (auxiliarOrientation instanceof West){
            lunarRover.moveRight();
        }
        if (auxiliarOrientation instanceof East){
            lunarRover.moveLeft();
        }
    }

    @Override
    public void rotateLeft() {
        auxiliarOrientation.rotateLeft();
    }

    @Override
    public void rotateRight() {
        auxiliarOrientation.rotateRight();
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
        return Objects.hash(auxiliarOrientation, lunarRover);
    }
}
