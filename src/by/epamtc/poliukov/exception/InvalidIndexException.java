package by.epamtc.poliukov.exception;

public class InvalidIndexException extends Exception{
    public InvalidIndexException() {
        super();
    }

    public InvalidIndexException(String message) {
        super(message);
    }

    public InvalidIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexException(Throwable cause) {
        super(cause);
    }
}
