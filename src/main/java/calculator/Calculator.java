package calculator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator {

    public abstract double evaluate(String input) throws RuntimeException;

    protected double calculate(double d1, char operator, double d2) {
        switch (operator) {
            case '+' -> { return d1 + d2; }
            case '-' -> { return d1 - d2; }
            case '*' -> { return d1 * d2; }
            case '/' -> { return d1 / d2; }
            default -> throw new UnknownError();
        }
    }

    protected String removeWhitespaces(String input) {
        return input.replace(" ","").replace("\n","").replace("\t","");
    }

    protected Queue<Double> parseDoubles(Queue<String> strings) throws NumberFormatException {
        Queue<Double> doubles = new LinkedList<>();
        while (!strings.isEmpty()) {
            doubles.add(Double.parseDouble(strings.poll()));
        }
        return doubles;
    }

}
