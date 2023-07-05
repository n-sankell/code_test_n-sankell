package calculator;

public class CalculatorBuilder {

    public Calculator getCalculator(int number) {
        switch (number){
            case 3 -> { return new OneOperatorCalculator(); }
            case 4 -> { return new SamePrecedenceCalculator(); }
            case 5 -> { return new DifferentPrecedenceCalculator(); }
            default -> { return null; }
        }
    }

}
