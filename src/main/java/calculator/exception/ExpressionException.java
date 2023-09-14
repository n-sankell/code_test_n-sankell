package calculator.exception;

public class ExpressionException extends RuntimeException {

    private final String message;

    public ExpressionException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
