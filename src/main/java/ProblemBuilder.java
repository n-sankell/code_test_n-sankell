import anagram.AnagramFinder;
import calculator.CalculatorBuilder;
import calculator.util.ExceptionHandler;
import webdriver.WebConstants;
import webdriver.WebDriver;

import java.util.Scanner;

public class ProblemBuilder {

    public void printProblem(int number) {
        switch (number) {
            case 1 -> useAnagramFinder();
            case 2 -> printProblem2();
            case 3 -> useCalculator(3);
            case 4 -> useCalculator(4);
            case 5 -> useCalculator(5);
        }
    }

    private void useAnagramFinder() {
        System.out.println("PROBLEM 1 \nIs it an anagram? \n");
        Scanner scanner = new Scanner(System.in);
        String[] args = new String[2];
        boolean loop = true;
        while (loop) {
            for (int i = 0; i < 2; i++) {
                System.out.println(i == 0 ? "Input first word" : "Input second word");
                args[i] = scanner.nextLine();
                if (args[i].equalsIgnoreCase("x")) {
                    System.out.println("Good bye");
                    loop = false;
                    break;
                }
            }
            if (loop) {
                System.out.println(AnagramFinder.isAnagram(args[0], args[1]) + "\n");
            }
        }
    }

    private void printProblem2() {
        WebDriver driver = new WebDriver();
        System.out.println("PROBLEM 2 \n");
        driver.printAllLinks(driver.findAllLinks(WebConstants.GOOGLE_ADDRESS));
    }

    private void useCalculator(int number) {
        System.out.println("PROBLEM "+ number + "\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input numbers");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("x")) {
                System.out.println("Good bye");
                break;
            }
            CalculatorBuilder builder = new CalculatorBuilder();
            System.out.println(ExceptionHandler.handleException(builder.getCalculator(number), input));
        }
    }

}
