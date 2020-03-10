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
    public void moveForward() {

    }

    @Override
    public void moveBackwards() {

    }
}
