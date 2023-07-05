import calculator.SamePrecedenceCalculator;
import calculator.constants.Constants;
import calculator.exception.*;
import org.junit.Test;

public class Problem4Test {

    private final SamePrecedenceCalculator calculator = new SamePrecedenceCalculator();

    @Test
    public void calculate1() throws Exception {
        assert calculator.evaluate("2+30+4") == 36;
    }

    @Test
    public void calculate2() throws Exception {
        assert calculator.evaluate("2 - 3 + 4 + 15") == 18;
    }

    @Test
    public void calculate3() throws Exception {
        assert calculator.evaluate("2 * 3 * 4") == 24;
    }

    @Test
    public void calculate4() throws Exception {
        assert calculator.evaluate("2 * 3 /  4 * 20") == 30;
    }

    @Test
    public void catchDifferentPrecedences1() throws Exception {
        try {
            calculator.evaluate("2 * 3 /  4 + 20");
        } catch (ExpressionException e) {
            assert e.getMessage().equals(Constants.DIFFERENT_PRECEDENCE);
        }
    }

    @Test
    public void catchDifferentPrecedences2() throws Exception {
        try {
            calculator.evaluate("2 * 3 /  4 - 20");
        } catch (ExpressionException e) {
            assert e.getMessage().equals(Constants.DIFFERENT_PRECEDENCE);
        }
    }

    @Test
    public void catchDifferentPrecedences3() throws Exception {
        try {
            calculator.evaluate("2 + 3 -  4 * 20");
        } catch (ExpressionException e) {
            assert e.getMessage().equals(Constants.DIFFERENT_PRECEDENCE);
        }
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
