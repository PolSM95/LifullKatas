package MarsRover.MarsRoverPackage;

import MarsRover.Cardinal.Cardinal;
import MarsRover.Coordinates;

public abstract class AbstractMarsRover implements MarsRover {
    protected Coordinates coordinates;
    protected Cardinal orientation;

    public AbstractMarsRover(Coordinates coordinates, Cardinal orientation) {

        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    @Override
    public void rotateRight() {
        orientation = orientation.rotateRight();
    }

    @Override
    public void rotateLeft() {
        orientation = orientation.rotateLeft();
    }

    @Override
    public void moveBackwards() {
        orientation.moveBackwards(coordinates);
    }

    @Override
    public void moveForward() {
        orientation.moveForward(coordinates);
    }

}
