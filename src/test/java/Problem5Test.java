import calculator.DifferentPrecedenceCalculator;
import calculator.constants.Constants;
import calculator.exception.ExpressionException;
import calculator.exception.NoOperatorException;
import calculator.exception.WrongNumberException;
import org.junit.Test;

public class Problem5Test {

    private final DifferentPrecedenceCalculator calculator = new DifferentPrecedenceCalculator();

    @Test
    public void calculate1() throws Exception {
        assert calculator.evaluate("2+3*40") == 122;
    }

    @Test
    public void calculate2() throws Exception {
        assert calculator.evaluate("2 * 3 + 4") == 10;
    }

    @Test
    public void calculate3() throws Exception {
        assert calculator.evaluate("2 / 3 + 4 - 1") == 3.666666666666667;
    }

    @Test
    public void calculate4() throws Exception {
        assert calculator.evaluate("2 - 3 *4 ") == -10;
    }

    @Test
    public void calculate5() throws Exception {
        assert calculator.evaluate("5*2+1-4/2+1") == 10;
    }


    @Test
    public void calculate6() throws Exception {
        assert calculator.evaluate("2 * 3 * 4") == 24;
    }

    @Test
    public void calculate7() throws Exception {
        assert calculator.evaluate("2 * 3 /  4 * 20") == 30;
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
