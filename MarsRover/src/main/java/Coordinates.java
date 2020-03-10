public class Coordinates {
    int xCoordinate;
    int yCoordinate;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    void updateCoordinates(int xCoordinate, int yCoordinate){
        this.xCoordinate += xCoordinate;
        this.yCoordinate += yCoordinate;
    }
}