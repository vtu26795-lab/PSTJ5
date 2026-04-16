import java.util.Arrays;

class ArrayUtils {

    // Function: returns sum of array
    public int sum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}

// Test class
class ArrayUtilsTest {

    static ArrayUtils utils = new ArrayUtils();

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

    // assertThrows
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

    // Empty input
    public static void testEmptyArray() {
        int[] arr = {};
        int result = utils.sum(arr);
        assertEquals(0, result, "Empty array");
    }

    // Null input
    public static void testNullArray() {
        assertThrows(() -> utils.sum(null), "Null array");
    }

    // Single element
    public static void testSingleElement() {
        int[] arr = {10};
        int result = utils.sum(arr);
        assertEquals(10, result, "Single element array");
    }
}

// Main class
public class Task9 {

    public static void main(String[] args) {
        System.out.println("Running Edge Case Tests...\n");

        ArrayUtilsTest.testEmptyArray();
        ArrayUtilsTest.testNullArray();
        ArrayUtilsTest.testSingleElement();
    }
}