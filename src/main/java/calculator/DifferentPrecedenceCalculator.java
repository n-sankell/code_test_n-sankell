package calculator;

import calculator.constants.Constants;
import calculator.exception.NoOperatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

        List<Double> doubles = new ArrayList<>(operands);
        List<Double> newDoubles = new ArrayList<>(doubles);
        List<Character> chars = new ArrayList<>(operators);
        List<Character> newChars = new ArrayList<>(chars);
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == '*' || chars.get(i) == '/') {
                indexes.add(i);
            }
        }
        double tempResult = doubles.get(indexes.get(0));
        int last = indexes.get(0);
        for (Integer i : indexes) {
            if (i == last+1) {
                tempResult = calculate(tempResult, chars.get(i), doubles.get(i+1));
                newDoubles.set(i, tempResult);
            } else {
                tempResult = calculate(newDoubles.get(i), chars.get(i), doubles.get(i+1));
                newDoubles.set(i, tempResult);
                tempResult = newDoubles.get(i);
            }
            newChars.remove(chars.get(i));
            last = i;
        }
        for (int i = indexes.size()-1; i >= 0 ; i--) {
            newDoubles.remove(indexes.get(i)+1);
        }

        double result = newDoubles.get(0);
        for (int i = 0; i < newChars.size(); i++) {
            result = calculate(result, newChars.get(i), newDoubles.get(i+1));
        }

        return newChars.size() > 0 ? result : tempResult;
    }

}
