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


    public String modifyString(String input) {
        return calcRec(-1,input.toCharArray(), "", "", "");
    }

    private String calcRec(int index, char[] input, String modified, String currentNumber, String lastNumber) {
        index++;
        if (index == input.length) {
            return modified;
        }

        if (input[index] == '-' || input[index] == '+') {
            lastNumber = currentNumber + input[index];
            return calcRec(index, input, modified + input[index], "", lastNumber);
        } else if (input[index] == '*' || input[index] == '/') {
            lastNumber = currentNumber;
            index = getNextIndex(index, input);
            return calcRec(index, input, modified + lastNumber, "", lastNumber);
        } else {
            currentNumber += input[index];
        }

        System.out.println(input[index]);
        System.out.println("current number " + currentNumber);
        System.out.println("last number " + lastNumber);

        return calcRec(index, input, modified + input[index], currentNumber, lastNumber);
    }

    private int getNextIndex(int index, char[] input) {
        index++;
        if (index == input.length) {
            return index;
        }
        if (CalculatorUtil.isOperator(input[index])) {
            return index;
        }
        return getNextIndex(index, input);
    }

    private String getNextNumber(int index, char[] input, String nextNumber) {
        index++;
        if (index == input.length) {
            return nextNumber;
        }
        if (CalculatorUtil.isOperator(input[index])) {
            return nextNumber;
        }
        return getNextNumber(index, input, nextNumber + input[index]);
    }

}
