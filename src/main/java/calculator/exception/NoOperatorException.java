package calculator.exception;

public class NoOperatorException extends RuntimeException {

    private final String message;

    public NoOperatorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
