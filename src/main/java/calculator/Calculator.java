package calculator;

public abstract class Calculator {

    public double evaluate(String input) throws Exception {
        return 0;
    }

    public double calculate(double d1, char operator, double d2) {

        switch (operator) {
            case '+' -> { return d1 + d2; }
            case '-' -> { return d1 - d2; }
            case '*' -> { return d1 * d2; }
            case '/' -> { return d1 / d2; }
            default -> { return 0; }
        }
    }

}
