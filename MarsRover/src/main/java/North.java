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
    public void moveForward() {

    }

    @Override
    public void moveBackwards() {

    }
}
