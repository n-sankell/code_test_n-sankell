package calculator;

import calculator.constants.Constants;
import calculator.exception.NoOperatorException;

import java.util.*;

public class DifferentPrecedenceCalculator extends SamePrecedenceCalculator {

    @Override
    protected boolean checkOperators(Queue<Character> operators) throws NoOperatorException {
        if (operators.isEmpty()) {
            throw new NoOperatorException(Constants.NO_OPERATORS);
        }
        return true;
    }

    @Override
    protected double getResult(Queue<Double> operands, Queue<Character> operators) {
        List<Double> doubles = new LinkedList<>(operands);
        List<Character> chars = new LinkedList<>(operators);

        while (chars.contains('*') || chars.contains('/')) {
            int index = -1;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i) == '*' || chars.get(i) == '/') {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                double result = calculate(doubles.get(index), chars.get(index), doubles.get(index + 1));
                doubles.set(index, result);
                doubles.remove(index + 1);
                chars.remove(index);
            }
        }

        double result = doubles.get(0);
        for (int i = 0; i < chars.size(); i++) {
            result = calculate(result, chars.get(i), doubles.get(i + 1));
        }

        return result;
    }

}
