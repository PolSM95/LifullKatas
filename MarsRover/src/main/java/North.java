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
    public Coordinates moveForward(Coordinates coordinates) {
        return null;
    }

    @Override
    public Coordinates moveBackwards(Coordinates coordinates) {
        return null;
    }
}
