package calculator.util;

import calculator.Calculator;

public class ExceptionHandler {

    public static String handleException(Calculator calculator, String input) {
        try {
            return CalculatorUtil.getResultString(calculator.evaluate(input));
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
