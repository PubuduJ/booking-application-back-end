package lk.ijse.dep9.app.service.exception;

public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException(String message) {
        super(message);
    }

    public InsufficientAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}
