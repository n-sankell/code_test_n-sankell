import calculator.exception.*;
import calculator.util.CalculatorUtil;
import calculator.OneOperatorCalculator;
import calculator.constants.Constants;
import org.junit.Test;

public class Problem3Test {

    private final OneOperatorCalculator calculator = new OneOperatorCalculator();

    @Test
    public void calculateAdd() throws Exception {
        assert calculator.evaluate("2+30") == 32;
    }

    @Test
    public void calculateMultiply() throws Exception {
        assert calculator.evaluate("2 * 3") == 6;
    }

    @Test
    public void calculateSubtract() throws Exception {
        assert calculator.evaluate("2 -3") == -1;
    }

    @Test
    public void calculateDivide() throws Exception {
        assert calculator.evaluate("2     / 3") == 0.6666666666666666;
    }

    @Test
    public void findOperator() {
        String input = "1-1";
        assert CalculatorUtil.findSingleOperator(input) == '-';
    }

    @Test
    public void catchNoOpException() throws Exception {
        try {
            calculator.evaluate("aaa");
        } catch (NoOperatorException e) {
            assert e.getMessage().equals(Constants.NO_OPERATORS);
        }
    }

    @Test
    public void catchTooManyOpException() throws Exception {
        try {
            calculator.evaluate("-*+");
        } catch (TooManyOperatorsException e) {
            assert e.getMessage().equals(Constants.TOO_MANY_OPERATORS);
        }
    }

    @Test
    public void catchTooFewOpException() throws Exception {
        try {
            calculator.evaluate("4524*");
        } catch (TooFewOperandsException e) {
            assert e.getMessage().equals(Constants.TOO_FEW_OPERANDS);
        }
    }

    @Test
    public void catchExpressionException() throws Exception {
        try {
            calculator.evaluate(" -4524");
        } catch (ExpressionException e) {
            assert e.getMessage().equals(Constants.WRONG_INPUT);
        }
    }

    @Test
    public void catchParseException() throws Exception {
        try {
            calculator.evaluate("56 + hoppsan");
        } catch (WrongNumberException e) {
            assert e.getMessage().equals(Constants.COULD_NOT_PARSE_DOUBLE);
        }
    }

}
