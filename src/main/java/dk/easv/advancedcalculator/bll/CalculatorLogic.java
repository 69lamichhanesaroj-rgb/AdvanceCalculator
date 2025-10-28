package dk.easv.advancedcalculator.bll;

public class CalculatorLogic {
    public String calculate(double input1, double input2, String operator) {
        double result = 0;

        switch (operator) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                if (input2 == 0)
                    return "Cannot divide by zero";
                else
                    result = input1 / input2;
                break;
            case "%":
                result = input1 % input2;
                break;
        }
        if (result == (long) result) {
            return (String.format("%d", (long) result));
        }
        else {
            return (String.format(String.valueOf(result)));
        }
    }
}