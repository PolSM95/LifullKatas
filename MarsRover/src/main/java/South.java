public class South implements Cardinal {
    @Override
    public Cardinal rotateLeft() {
        return new East();
    }

    @Override
    public Cardinal rotateRight() {
        return new West();
    }

    @Override
    public void moveForward(Coordinates coordinates) {

    }

    @Override
    public void moveBackwards(Coordinates coordinates) {

    }
}
