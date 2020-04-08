package exception;

public class BasketNotExistsException extends RuntimeException{
    public BasketNotExistsException(String message) {
        super(message);
    }
}
