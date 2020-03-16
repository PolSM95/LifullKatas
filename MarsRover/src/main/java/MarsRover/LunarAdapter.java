package MarsRover;

import MarsRover.Cardinal.*;
import MarsRover.MarsRoverPackage.AbstractMarsRover;

public class LunarAdapter extends AbstractMarsRover {

    private Cardinal auxiliarOrientation;
    private LunarRover lunarRover;

    public LunarAdapter(Coordinates coordinates, Cardinal orientation) {
        super(coordinates, orientation);
        auxiliarOrientation = orientation;
        lunarRover = new LunarRover(coordinates.xCoordinate,coordinates.yCoordinate);

    }


    public void  rotateAdapter(){

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
}
