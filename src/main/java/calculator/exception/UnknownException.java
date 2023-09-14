package calculator.exception;

public class UnknownException extends RuntimeException {

    private final String message;

    public UnknownException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
