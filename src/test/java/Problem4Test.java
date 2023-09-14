import calculator.SamePrecedenceCalculator;
import calculator.exception.ExpressionException;
import calculator.exception.NoOperatorException;
import calculator.exception.WrongNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem4Test {

    private final SamePrecedenceCalculator calculator = new SamePrecedenceCalculator();

    @Test
    public void calculate1() {
        assertEquals(2 + 30 +4, calculator.evaluate("2+30+4"),0);
    }

    @Test
    public void calculate2() {
        assertEquals(2 - 3 + 4 + 15 , calculator.evaluate("2 - 3 + 4 + 15"), 0);
    }

    @Test
    public void calculate3() {
        assertEquals(2 * 3 * 4, calculator.evaluate("2 * 3 * 4"), 0);
    }

    @Test
    public void calculate4() {
        assertEquals(2.0 * 3 / 4 * 20, calculator.evaluate("2 * 3 /  4 * 20"), 0);
    }

    @Test
    public void previousCases() throws Exception {
        assertEquals(2 + 30, calculator.evaluate("2+30"), 0);
        assertEquals(2 * 3, calculator.evaluate("2 * 3"), 0);
        assertEquals(2 - 3, calculator.evaluate("2 -3"), 0);
        assertEquals(2.0 / 3, calculator.evaluate("2     / 3"), 0);
    }

    @Test(expected = ExpressionException.class)
    public void catchDifferentPrecedences1() {
        calculator.evaluate("2 * 3 /  4 + 20");
    }

    @Test(expected = ExpressionException.class)
    public void catchDifferentPrecedences2() {
        calculator.evaluate("2 * 3 /  4 - 20");
    }

    @Test(expected = ExpressionException.class)
    public void catchDifferentPrecedences3() {
        calculator.evaluate("2 + 3 -  4 * 20");
    }

    @Test(expected = NoOperatorException.class)
    public void catchNoOpException() {
        calculator.evaluate("aaa");
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
