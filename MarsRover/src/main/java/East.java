public class East implements Cardinal {
    @Override
    public Cardinal rotateLeft() {
        return new North();
    }

    @Override
    public Cardinal rotateRight() {
        return new South();
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
