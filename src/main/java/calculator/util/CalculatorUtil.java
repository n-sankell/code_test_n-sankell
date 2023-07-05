package calculator.util;

import java.util.*;

public class CalculatorUtil {

    public static char findSingleOperator(String input) {
        char[] chars = input.toCharArray();
        char operator = ' ';
        for (char c : chars) {
            if (isOperator(c)) {
                operator = c;
            }
        }
        return operator;
    }

    public static boolean hasOneOperator(String input) {
        return countOperators(input) == 1;
    }

    public static int countOperators(String input) {
        char[] chars = input.toCharArray();
        int counter = 0;
        for (char c : chars) {
            if (isOperator(c)) {
                counter++;
            }
        }
        return counter;
    }

    public static Queue<String> getOperands(String input) {
        Queue<String> strings = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (isOperator(c)) {
                strings.add(String.valueOf(builder));
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        strings.add(String.valueOf(builder));
        return strings;
    }

    public static Queue<Character> getOperators(String input) {
        Queue<Character> chars = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (isOperator(c)) {
                chars.add(c);
            }
        }
        return chars;
    }

    public static boolean checkExpression(String input) {
        char prev = ' ';
        for (char current : input.toCharArray()) {
            if (isOperator(current) && isOperator(prev)) {
                return false;
            }
            prev = current;
        }
        return true;
    }

    public static int getOperatorGroup(char operator) {
        return operator == '+' || operator == '-' ? 1 : 2;
    }

    private static boolean hasDigit(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasAnyOperator(String input) {
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return true;
            }
        }
        return false;
    }

    protected static boolean checkOperators(String input) {
        String[] array = input.split("[+-]");
        Arrays.stream(array).forEach(System.out::println);
        return true;
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String getResultString(double result) {
        String resultString = String.valueOf(result);
        if (resultString.endsWith(".0")) {
            return resultString.replaceAll("\\.0", "");
        }
        return resultString;
    }

}
