package MarsRover;

public class Coordinates {
    public int xCoordinate;
    public int yCoordinate;
    public int velocity;
    private final static int X_COORDINATE_LIMIT = 20;
    private final static int Y_COORDINATE_LIMIT = 20;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.velocity = 1;
    }

    public Coordinates(Coordinates coordinates, int velocity) {
        this.xCoordinate = coordinates.xCoordinate;
        this.yCoordinate = coordinates.yCoordinate;
        this.velocity = velocity;
    }


    public void moveUp(){
        this.yCoordinate += velocity;
        if(yCoordinate > Y_COORDINATE_LIMIT){
            this.yCoordinate -= Y_COORDINATE_LIMIT + 1;
        }
    }
    public void moveDown(){
        this.yCoordinate -= velocity;
        if(yCoordinate < 0 ){
            this.yCoordinate = Y_COORDINATE_LIMIT + yCoordinate;
        }
    }
    public void moveLeft(){
        this.xCoordinate -= velocity;
        if(xCoordinate < 0){
            this.xCoordinate = X_COORDINATE_LIMIT + xCoordinate;
        }
    }
    public void moveRight(){
        this.xCoordinate += velocity;
        if(xCoordinate > X_COORDINATE_LIMIT){
            this.xCoordinate = (this.xCoordinate - X_COORDINATE_LIMIT) - 1;
        }
    }
}