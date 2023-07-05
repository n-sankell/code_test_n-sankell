package calculator;

import java.util.Stack;

public abstract class Calculator {

    public double evaluate(String input) throws Exception {
        return 0;
    }

    protected double calculate(double d1, char operator, double d2) {
        switch (operator) {
            case '+' -> { return d1 + d2; }
            case '-' -> { return d1 - d2; }
            case '*' -> { return d1 * d2; }
            case '/' -> { return d1 / d2; }
            default -> { return 0; }
        }
    }

    protected String trimInput(String input) {
        return input.replace(" ","");
    }

}
