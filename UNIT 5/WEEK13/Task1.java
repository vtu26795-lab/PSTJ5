import java.util.*;

// Calculator class
class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

// Test class
public class Task1 {

    static Calculator calc = new Calculator();

    // Assertion methods
    public static void assertEqual(double expected, double actual, String message) {
        if (Math.abs(expected - actual) < 0.0001) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL: " + message + 
                               " | Expected: " + expected + 
                               " | Got: " + actual);
        }
    }

    public static void assertException(Runnable code, String message) {
        try {
            code.run();
            System.out.println("❌ FAIL: " + message + " (No Exception)");
        } catch (Exception e) {
            System.out.println("✅ PASS (Exception Caught: " + e.getMessage() + ")");
        }
    }

    // -------- TEST CASES --------

    public static void testAddition() {
        System.out.println("\n--- Addition Tests ---");

        assertEqual(5, calc.add(2, 3), "2 + 3");
        assertEqual(-5, calc.add(-2, -3), "-2 + -3");
        assertEqual(2, calc.add(5, -3), "5 + -3");
        assertEqual(5, calc.add(0, 5), "0 + 5");
        assertEqual(1000000, calc.add(999999, 1), "Large numbers");
    }

    public static void testSubtraction() {
        System.out.println("\n--- Subtraction Tests ---");

        assertEqual(2, calc.subtract(5, 3), "5 - 3");
        assertEqual(-2, calc.subtract(3, 5), "3 - 5");
        assertEqual(-2, calc.subtract(-5, -3), "-5 - (-3)");
        assertEqual(-5, calc.subtract(0, 5), "0 - 5");
        assertEqual(999999, calc.subtract(1000000, 1), "Large numbers");
    }

    public static void testDivision() {
        System.out.println("\n--- Division Tests ---");

        assertEqual(5, calc.divide(10, 2), "10 / 2");
        assertEqual(3, calc.divide(9, 3), "9 / 3");
        assertEqual(3.5, calc.divide(7, 2), "7 / 2");
        assertEqual(0, calc.divide(0, 5), "0 / 5");
        assertEqual(-5, calc.divide(-10, 2), "-10 / 2");
        assertEqual(-5, calc.divide(10, -2), "10 / -2");
        assertEqual(5, calc.divide(-10, -2), "-10 / -2");

        // Boundary case: division by zero
        assertException(() -> calc.divide(5, 0), "Division by zero");
    }

    // Main method
    public static void main(String[] args) {
        testAddition();
        testSubtraction();
        testDivision();
    }
}