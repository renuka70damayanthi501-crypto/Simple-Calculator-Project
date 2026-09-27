public class Calculator {

    public double calculate(double first, double second, String operator) {

        switch (operator) {

            case "+":
                return first + second;

            case "−":
                return first - second;

            case "×":
                return first * second;

            case "÷":
                if (second == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return first / second;

            default:
                return second;
        }
    }

    public double percentage(double value) {
        return value / 100.0;
    }

    public double square(double value) {
        return value * value;
    }

    public double squareRoot(double value) {

        if (value < 0) {
            throw new ArithmeticException("Invalid input");
        }

        return Math.sqrt(value);
    }

    public double reciprocal(double value) {

        if (value == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return 1.0 / value;
    }
}