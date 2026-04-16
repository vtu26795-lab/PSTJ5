class SimpleMath {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

// Test class (JUnit-like, no public keyword)
class SimpleMathTest {

    static SimpleMath math = new SimpleMath();

    // assertEquals method
    public static void assertEquals(int expected, int actual, String testName) {
        if (expected == actual) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // assertThrows method
    public static void assertThrows(Runnable code, String testName) {
        try {
            code.run();
            System.out.println("❌ FAIL: " + testName + " (No Exception)");
        } catch (Exception e) {
            System.out.println("✅ PASS: " + testName +
                    " (Caught: " + e.getMessage() + ")");
        }
    }

    // -------- TEST METHODS --------

    public static void testAddition() {
        assertEquals(5, math.add(2, 3), "Addition 2+3");
        assertEquals(0, math.add(-2, 2), "Addition -2+2");
    }

    public static void testSubtraction() {
        assertEquals(1, math.subtract(3, 2), "Subtraction 3-2");
        assertEquals(-1, math.subtract(2, 3), "Subtraction 2-3");
    }

    public static void testMultiplication() {
        assertEquals(6, math.multiply(2, 3), "Multiplication 2*3");
        assertEquals(0, math.multiply(5, 0), "Multiplication 5*0");
    }

    public static void testDivision() {
        assertEquals(2, math.divide(6, 3), "Division 6/3");
        assertEquals(-2, math.divide(6, -3), "Division 6/-3");
    }

    public static void testDivisionByZero() {
        assertThrows(() -> math.divide(5, 0), "Division by Zero");
    }
}

// Main class (entry point)
public class Task3 {

    public static void main(String[] args) {
        System.out.println("Running SimpleMath Tests...\n");

        SimpleMathTest.testAddition();
        SimpleMathTest.testSubtraction();
        SimpleMathTest.testMultiplication();
        SimpleMathTest.testDivision();
        SimpleMathTest.testDivisionByZero();
    }
}