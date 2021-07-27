package by.epamtc.poliukov.exception;

public class IllegalFuelConsumptionException extends Exception {
    public IllegalFuelConsumptionException() {
        super();
    }

    public IllegalFuelConsumptionException(String message) {
        super(message);
    }

    public IllegalFuelConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFuelConsumptionException(Throwable cause) {
        super(cause);
    }
}
