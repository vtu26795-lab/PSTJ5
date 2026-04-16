class Calculator {

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

// Test class
class CalculatorTest {

    static Calculator calc = new Calculator();

    // assertEquals
    public static void assertEquals(int expected, int actual, String testName) {
        if (expected == actual) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // assertThrows (manual version)
    public static void assertThrows(Runnable code, String testName) {
        try {
            code.run();
            System.out.println("❌ FAIL: " + testName + " (No Exception)");
        } catch (Exception e) {
            System.out.println("✅ PASS: " + testName +
                    " (Caught: " + e.getMessage() + ")");
        }
    }

    // -------- TEST CASES --------

    public static void testNormalDivision() {
        assertEquals(5, calc.divide(10, 2), "10 / 2");
        assertEquals(-5, calc.divide(10, -2), "10 / -2");
        assertEquals(0, calc.divide(0, 5), "0 / 5");
    }

    public static void testDivisionByZero() {
        assertThrows(() -> calc.divide(5, 0), "Division by zero");
    }
}

// Main class
public class Task5 {

    public static void main(String[] args) {
        System.out.println("Running Divide Method Tests...\n");

        CalculatorTest.testNormalDivision();
        CalculatorTest.testDivisionByZero();
    }
}