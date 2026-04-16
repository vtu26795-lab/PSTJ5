class Logger {

    public static void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }

    public static void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}

// Example class using logging
class Calculator {

    public int divide(int a, int b) {

        Logger.info("Starting division operation");

        Logger.debug("Input values: a=" + a + ", b=" + b);

        if (b == 0) {
            Logger.error("Division by zero attempted!");
            throw new ArithmeticException("Cannot divide by zero");
        }

        int result = a / b;

        Logger.info("Division successful. Result = " + result);

        return result;
    }
}

// Main class
public class Task9 {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        try {
            calc.divide(10, 2);
            calc.divide(5, 0); // will trigger error
        } catch (Exception e) {
            Logger.error("Exception caught: " + e.getMessage());
        }
    }
}