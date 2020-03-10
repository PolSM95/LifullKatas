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
    public void moveForward() {

    }

    @Override
    public void moveBackwards() {

    }
}
