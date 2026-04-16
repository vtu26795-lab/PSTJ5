class PrimeChecker {

    public boolean isPrime(int num) {

        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Test class (Parameterized style)
class PrimeCheckerTest {

    static PrimeChecker checker = new PrimeChecker();

    // assertEquals
    public static void assertEquals(boolean expected, boolean actual, String testName) {
        if (expected == actual) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // Parameterized test method
    public static void testPrimeNumbers() {

        int[] inputs = {2, 3, 5, 7, 11};
        boolean[] expected = {true, true, true, true, true};

        for (int i = 0; i < inputs.length; i++) {
            boolean result = checker.isPrime(inputs[i]);
            assertEquals(expected[i], result, "Prime test: " + inputs[i]);
        }
    }

    public static void testNonPrimeNumbers() {

        int[] inputs = {0, 1, 4, 6, 9, 10};
        boolean[] expected = {false, false, false, false, false, false};

        for (int i = 0; i < inputs.length; i++) {
            boolean result = checker.isPrime(inputs[i]);
            assertEquals(expected[i], result, "Non-prime test: " + inputs[i]);
        }
    }

    public static void testNegativeNumbers() {

        int[] inputs = {-1, -5, -10};
        boolean[] expected = {false, false, false};

        for (int i = 0; i < inputs.length; i++) {
            boolean result = checker.isPrime(inputs[i]);
            assertEquals(expected[i], result, "Negative test: " + inputs[i]);
        }
    }
}

// Main class
public class Task6 {

    public static void main(String[] args) {
        System.out.println("Running Prime Number Tests...\n");

        PrimeCheckerTest.testPrimeNumbers();
        PrimeCheckerTest.testNonPrimeNumbers();
        PrimeCheckerTest.testNegativeNumbers();
    }
}