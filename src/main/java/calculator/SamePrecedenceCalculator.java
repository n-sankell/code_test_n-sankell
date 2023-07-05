package calculator;

import calculator.constants.Constants;
import calculator.exception.ExpressionException;
import calculator.exception.NoOperatorException;
import calculator.exception.WrongNumberException;
import calculator.util.CalculatorUtil;

import java.util.*;

public class SamePrecedenceCalculator extends Calculator {

    @Override
    public double evaluate(String input) throws ExpressionException, NoOperatorException, WrongNumberException {
        String trimmedInput = trimInput(input);

        if (CalculatorUtil.isOperator(trimmedInput.charAt(0)) || CalculatorUtil.isOperator(trimmedInput.charAt(trimmedInput.length()-1))) {
            throw new ExpressionException(Constants.WRONG_INPUT);
        } else if (!CalculatorUtil.checkExpression(trimmedInput)) {
            throw new ExpressionException(Constants.WRONG_INPUT);
        }

        Queue<Character> operators = CalculatorUtil.getOperators(input);

        if (!checkOperators(operators)) {
            throw new ExpressionException(Constants.DIFFERENT_PRECEDENCE);
        }

        try {
            Queue<Double> operands = parseDoubles(CalculatorUtil.getOperands(input));
            return getResult(operands, operators);
        } catch (NumberFormatException e) {
            throw new WrongNumberException(Constants.COULD_NOT_PARSE_DOUBLE);
        }
    }

    protected double getResult(Queue<Double> operands, Queue<Character> operators) {
        double result = !operands.isEmpty() ? operands.poll() : 0;

        while (!operands.isEmpty()) {
            double operand = operands.poll();
            if (!operators.isEmpty()) {
                result = calculate(result, operators.poll(), operand);
            }
        }
        return result;
    }

    protected boolean checkOperators(Queue<Character> operators) throws NoOperatorException {
        if (operators.isEmpty()) {
            throw new NoOperatorException(Constants.NO_OPERATORS);
        }
        int operatorGroup = CalculatorUtil.getOperatorGroup(operators.peek());
        for (Character current : operators) {
            if (CalculatorUtil.getOperatorGroup(current) != operatorGroup) {
                return false;
            }
        }
        return true;
    }

    private Queue<Double> parseDoubles(Queue<String> strings) throws NumberFormatException {
        Queue<Double> doubles = new LinkedList<>();
        while (!strings.isEmpty()) {
            doubles.add(Double.parseDouble(strings.poll()));
        }
        return doubles;
    }

}
