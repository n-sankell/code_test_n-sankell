package calculator.exception;

public class WrongNumberException extends RuntimeException {

    private final String message;

    public WrongNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
