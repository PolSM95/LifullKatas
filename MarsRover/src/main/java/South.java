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
    public Coordinates moveForward(Coordinates coordinates) {
return null;
    }

    @Override
    public Coordinates moveBackwards(Coordinates coordinates) {
return null;
    }
}
