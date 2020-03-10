public class Coordinates {
    int xCoordinate;
    int yCoordinate;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void moveUp(){
        this.yCoordinate++;
    }
    public void moveDown(){
        this.yCoordinate--;
    }
    public void moveLeft(){
        this.xCoordinate--;
    }
    public void moveRight(){
        this.xCoordinate++;
    }
}