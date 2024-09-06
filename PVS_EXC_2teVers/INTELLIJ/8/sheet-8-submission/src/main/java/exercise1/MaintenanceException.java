package exercise1;

public class MaintenanceException extends Exception {
    public MaintenanceException() {
    }

    public MaintenanceException(String message) {
        super(message);
    }

    public MaintenanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaintenanceException(Throwable cause) {
        super(cause);
    }

    public MaintenanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
