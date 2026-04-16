import java.util.*;

public class Task2 {

    // Function with IF-ELSE + LOOP
    public static int processNumbers(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                sum += arr[i];        // Path 1 (positive)

            } else if (arr[i] < 0) {
                sum -= arr[i];        // Path 2 (negative)

            } else {
                sum += 0;             // Path 3 (zero)
            }
        }

        return sum;
    }

    // Assertion method
    public static void assertEqual(int expected, int actual, String msg) {
        if (expected == actual) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL: " + msg + 
                               " | Expected: " + expected + 
                               " | Got: " + actual);
        }
    }

    // -------- WHITE-BOX TEST CASES --------

    // Path 1: Only positive numbers
    public static void testPositivePath() {
        System.out.println("\nTest: All Positive");
        int[] arr = {1, 2, 3};
        int result = processNumbers(arr);
        assertEqual(6, result, "Positive numbers path");
    }

    // Path 2: Only negative numbers
    public static void testNegativePath() {
        System.out.println("\nTest: All Negative");
        int[] arr = {-1, -2, -3};
        int result = processNumbers(arr);
        // sum -= (-1) = +1, so total = 6
        assertEqual(6, result, "Negative numbers path");
    }

    // Path 3: Contains zero
    public static void testZeroPath() {
        System.out.println("\nTest: Contains Zero");
        int[] arr = {0, 0, 0};
        int result = processNumbers(arr);
        assertEqual(0, result, "Zero path");
    }

    // Mixed path (covers all branches)
    public static void testMixedPath() {
        System.out.println("\nTest: Mixed Values");
        int[] arr = {2, -3, 0, 4};
        int result = processNumbers(arr);
        // 2 + 3 + 0 + 4 = 9
        assertEqual(9, result, "Mixed path");
    }

    // Loop boundary: empty array
    public static void testEmptyArray() {
        System.out.println("\nTest: Empty Array");
        int[] arr = {};
        int result = processNumbers(arr);
        assertEqual(0, result, "Loop not executed");
    }

    // Main method
    public static void main(String[] args) {
        testPositivePath();
        testNegativePath();
        testZeroPath();
        testMixedPath();
        testEmptyArray();
    }
}