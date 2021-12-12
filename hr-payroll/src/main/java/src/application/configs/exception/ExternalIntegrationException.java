package src.application.configs.exception;

public class ExternalIntegrationException extends RuntimeException {

    public ExternalIntegrationException(String message) {
        super("Error " + message + " Integration");
    }
}
