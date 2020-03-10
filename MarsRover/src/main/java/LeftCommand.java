public class LeftCommand implements Command {
    private Cardinal orientation;

    public LeftCommand(Cardinal orientation) {

        this.orientation = orientation;
    }

    @Override
    public void execute() {
        orientation = orientation.rotateLeft();
    }
}
