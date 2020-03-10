public class RightCommand implements Command {
    private Cardinal orientation;

    public RightCommand(Cardinal orientation) {

        this.orientation = orientation;
    }

    @Override
    public void execute() {
        orientation = orientation.rotateRight();
    }
}
