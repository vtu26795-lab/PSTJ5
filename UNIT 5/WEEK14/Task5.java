class EvenOddChecker {

    public String check(int num) {
        if (num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}

// Test class
class EvenOddTest {

    static EvenOddChecker checker = new EvenOddChecker();

    // assertEquals
    public static void assertEquals(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + expected +
                    " | Got: " + actual);
        }
    }

    // -------- TEST CASES --------

    public static void testPositiveNumbers() {
        assertEquals("Even", checker.check(2), "2 is Even");
        assertEquals("Odd", checker.check(3), "3 is Odd");
    }

    public static void testNegativeNumbers() {
        assertEquals("Even", checker.check(-4), "-4 is Even");
        assertEquals("Odd", checker.check(-7), "-7 is Odd");
    }

    public static void testZero() {
        assertEquals("Even", checker.check(0), "0 is Even");
    }

    public static void testLargeNumbers() {
        assertEquals("Even", checker.check(1000000), "Large Even");
        assertEquals("Odd", checker.check(999999), "Large Odd");
    }
}

// Main class
public class Task5 {

    public static void main(String[] args) {
        System.out.println("Running Even/Odd Tests...\n");

        EvenOddTest.testPositiveNumbers();
        EvenOddTest.testNegativeNumbers();
        EvenOddTest.testZero();
        EvenOddTest.testLargeNumbers();
    }
}