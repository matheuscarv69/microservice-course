package src.application.configs.exception;

public class ExternalTimeoutException extends RuntimeException {

    public ExternalTimeoutException(String message) {
        super(message + " did not respond");
    }
}
