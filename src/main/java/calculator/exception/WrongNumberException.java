package calculator.exception;

public class WrongNumberException extends Exception {

    private final String message;

    public WrongNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
