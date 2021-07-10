package exception;

public class UnsupportedCategoryException extends Exception {
    public UnsupportedCategoryException() {
        super();
    }

    public UnsupportedCategoryException(String message) {
        super(message);
    }

    public UnsupportedCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedCategoryException(Throwable cause) {
        super(cause);
    }
}
