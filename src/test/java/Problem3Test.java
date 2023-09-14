import calculator.OneOperatorCalculator;
import calculator.exception.*;
import calculator.util.CalculatorUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem3Test {

    private final OneOperatorCalculator calculator = new OneOperatorCalculator();

    @Test
    public void calculateAdd() throws Exception {
        assertEquals(2 + 30, calculator.evaluate("2+30"), 0);
    }

    @Test
    public void calculateMultiply() {
        assertEquals(2 * 3, calculator.evaluate("2 * 3"), 0);
    }

    @Test
    public void calculateSubtract() {
        assertEquals(2 - 3, calculator.evaluate("2 -3"), 0);
    }

    @Test
    public void calculateDivide() {
        assertEquals(2.0 / 3, calculator.evaluate("2     / 3"), 0);
    }

    @Test
    public void findOperator() {
        assertEquals('-', CalculatorUtil.findSingleOperator("1-1"));
    }

    @Test(expected = NoOperatorException.class)
    public void catchNoOpException() throws RuntimeException {
        calculator.evaluate("aaa");
    }

    @Test(expected = TooManyOperatorsException.class)
    public void catchTooManyOpException() {
        calculator.evaluate("-*+");
    }

    @Test(expected = TooFewOperandsException.class)
    public void catchTooFewOpException() {
        calculator.evaluate("4524*");
    }

    @Test(expected = ExpressionException.class)
    public void catchExpressionException() {
        calculator.evaluate(" -4524");
    }

    @Test(expected = WrongNumberException.class)
    public void catchParseException() {
        calculator.evaluate("56 + hoppsan");
    }

}
