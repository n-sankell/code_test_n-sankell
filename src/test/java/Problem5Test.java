import calculator.DifferentPrecedenceCalculator;
import calculator.exception.ExpressionException;
import calculator.exception.NoOperatorException;
import calculator.exception.WrongNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem5Test {

    private final DifferentPrecedenceCalculator calculator = new DifferentPrecedenceCalculator();

    @Test
    public void calculate1() throws Exception {
        assertEquals(2+3*40, calculator.evaluate("2+3*40"), 0);
    }

    @Test
    public void calculate2() throws Exception {
        assertEquals(2 * 3 + 4, calculator.evaluate("2 * 3 + 4"), 0);
    }

    @Test
    public void calculate3() throws Exception {
        assertEquals(2.0 / 3 + 4 - 1, calculator.evaluate("2 / 3 + 4 - 1"), 0);
    }

    @Test
    public void calculate4() throws Exception {
        assertEquals(2-3*4, calculator.evaluate("2 - 3 *4 "), 0);
    }

    @Test
    public void calculate5() throws Exception {
        assertEquals(5*2+1-4.0/2+1, calculator.evaluate("5*2+1-4/2+1"), 0);
    }

    @Test
    public void calculate6() throws Exception {
        assertEquals(2 * 3 * 4, calculator.evaluate("2 * 3 * 4"), 0);
    }

    @Test
    public void calculate7() throws Exception {
        assertEquals(2.0 * 3 / 4 * 20, calculator.evaluate("2 * 3 /  4 * 20"), 0);
    }

    @Test
    public void calculate8() throws Exception {
        assertEquals(5 * 2 * 2 + 1 - 4.0 / 2 + 1, calculator.evaluate("5*2*2 +1 -4 / 2 +1"), 0);
    }

    @Test
    public void previousCases() throws Exception {
        assertEquals(2 + 30, calculator.evaluate("2+30"), 0);
        assertEquals(2 * 3, calculator.evaluate("2 * 3"), 0);
        assertEquals(2 - 3, calculator.evaluate("2 -3"), 0);
        assertEquals(2.0 / 3, calculator.evaluate("2     / 3"), 0);
        assertEquals(2.0 * 3 / 4 * 20, calculator.evaluate("2 * 3 /  4 * 20"), 0);
        assertEquals(2 * 3 * 4, calculator.evaluate("2 * 3 * 4"), 0);
        assertEquals(2 - 3 + 4 + 15 , calculator.evaluate("2 - 3 + 4 + 15"), 0);
    }

    @Test(expected = NoOperatorException.class)
    public void catchNoOpException1() {
        calculator.evaluate("124");
    }

    @Test(expected = NoOperatorException.class)
    public void catchNoOpException2() {
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
