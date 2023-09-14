package calculator;

import calculator.constants.Constants;
import calculator.exception.ExpressionException;
import calculator.exception.NoOperatorException;
import calculator.exception.WrongNumberException;
import calculator.util.CalculatorUtil;

import java.util.*;

public class DifferentPrecedenceCalculator extends Calculator {

    @Override
    public double evaluate(String input) throws ExpressionException, NoOperatorException, WrongNumberException {
        String trimmedInput = removeWhitespaces(input);

        if (CalculatorUtil.isOperator(trimmedInput.charAt(0)) || CalculatorUtil.isOperator(trimmedInput.charAt(trimmedInput.length()-1))) {
            throw new ExpressionException(Constants.WRONG_INPUT);
        } else if (!CalculatorUtil.checkExpression(trimmedInput)) {
            throw new ExpressionException(Constants.WRONG_INPUT);
        }

        Queue<Character> operators = CalculatorUtil.getOperators(input);

        if (operators.isEmpty()) {
            throw new NoOperatorException(Constants.NO_OPERATORS);
        }

        try {
            Queue<Double> operands = parseDoubles(CalculatorUtil.getOperands(input));
            return getResult(operands, operators);
        } catch (NumberFormatException e) {
            throw new WrongNumberException(Constants.COULD_NOT_PARSE_DOUBLE);
        }
    }

    protected double getResult(Queue<Double> _operands, Queue<Character> _operators) {
        List<Double> operands = new LinkedList<>(_operands);
        List<Character> operators = new LinkedList<>(_operators);

        while (operators.contains('*') || operators.contains('/')) {
            int index = -1;
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '*' || operators.get(i) == '/') {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                double result = calculate(operands.get(index), operators.get(index), operands.get(index + 1));
                operands.set(index, result);
                operands.remove(index + 1);
                operators.remove(index);
            }
        }

        double result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = calculate(result, operators.get(i), operands.get(i + 1));
        }

        return result;
    }

}
