public class North implements Cardinal {
    @Override
    public Cardinal rotateLeft() {
        return new West();
    }

    @Override
    public Cardinal rotateRight() {
        return new East();
    }

    @Override
    public void moveForward(Coordinates coordinates) {
        coordinates.updateCoordinates(0,1);
    }

    @Override
    public void moveBackwards(Coordinates coordinates) {
        coordinates.updateCoordinates(0,-1);
    }
}
