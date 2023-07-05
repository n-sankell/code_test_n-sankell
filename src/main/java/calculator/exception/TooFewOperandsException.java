package calculator.exception;

public class TooFewOperandsException extends Exception {

    private final String message;

    public TooFewOperandsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
