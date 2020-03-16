package MarsRover;

import MarsRover.Cardinal.Cardinal;
import MarsRover.Cardinal.North;
import MarsRover.MarsRoverPackage.AbstractMarsRover;

public class LunarAdapter extends AbstractMarsRover {


    public LunarAdapter(Coordinates coordinates, Cardinal orientation) {
        super(coordinates, orientation);

    }


    public void  rotateAdapter(Coordinates coordinates,Cardinal orientation){


    }


    @Override
    public void moveForward() {
        //if(orientation instanceof North){}
        //up N

    }

    @Override
    public void moveBackwards() {
        //down N

    }

    @Override
    public void rotateLeft() {
        super.rotateLeft();
    }

    @Override
    public void rotateRight() {
        super.rotateRight();
    }
}
