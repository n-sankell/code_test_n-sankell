package calculator.exception;

public class TooManyOperatorsException extends Exception {

    private final String message;

    public TooManyOperatorsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
