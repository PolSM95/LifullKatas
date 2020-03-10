public class West implements Cardinal {
    @Override
    public Cardinal rotateLeft() {
        return new South();
    }

    @Override
    public Cardinal rotateRight() {
        return new North();
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
