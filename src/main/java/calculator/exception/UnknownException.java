package calculator.exception;

public class UnknownException extends Exception {

    private final String message;

    public UnknownException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
