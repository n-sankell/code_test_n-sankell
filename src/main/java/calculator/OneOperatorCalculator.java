package calculator;

import calculator.constants.Constants;
import calculator.exception.*;
import calculator.util.CalculatorUtil;

import java.util.Arrays;

public class OneOperatorCalculator extends Calculator {

    @Override
    public double evaluate(String input) throws RuntimeException {
        String trimmedInput = removeWhitespaces(input);

        if (CalculatorUtil.countOperators(trimmedInput) > 1) {
            throw new TooManyOperatorsException(Constants.TOO_MANY_OPERATORS);
        }
        char operator = CalculatorUtil.findSingleOperator(trimmedInput);
        try {
            double[] operands = getOperands(trimmedInput, operator);
            return calculate(operands[0], operator, operands[1]);
        } catch (NumberFormatException e) {
            throw new WrongNumberException(Constants.COULD_NOT_PARSE_DOUBLE);
        }
    }

    public double[] getOperands(String input, char operator) throws TooFewOperandsException, NumberFormatException, ExpressionException {
        String pattern = operator == '+' ? "\\+" : operator == '*' ? "\\*" : String.valueOf(operator);
        String[] splitArray = input.split(pattern);

        if (CalculatorUtil.isOperator(input.charAt(0))) {
            throw new ExpressionException(Constants.WRONG_INPUT);
        } else if (splitArray.length != 2) {
            throw new TooFewOperandsException(Constants.TOO_FEW_OPERANDS);
        }

        return Arrays.stream(splitArray).mapToDouble(Double::parseDouble).toArray();
    }

}
