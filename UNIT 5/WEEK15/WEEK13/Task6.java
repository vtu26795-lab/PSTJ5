import java.util.Arrays;

class SortUtils {

    // Simple sorting function (Bubble Sort)
    public int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

// Test class
class SortUtilsTest {

    static SortUtils sorter = new SortUtils();

    // assertEquals for arrays
    public static void assertArrayEquals(int[] expected, int[] actual, String testName) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("✅ PASS: " + testName);
        } else {
            System.out.println("❌ FAIL: " + testName +
                    " | Expected: " + Arrays.toString(expected) +
                    " | Got: " + Arrays.toString(actual));
        }
    }

    // -------- TEST CASES --------

    public static void testNormalArray() {
        int[] input = {5, 2, 8, 1};
        int[] expected = {1, 2, 5, 8};

        int[] result = sorter.sort(input);
        assertArrayEquals(expected, result, "Normal array sorting");
    }

    public static void testAlreadySorted() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};

        int[] result = sorter.sort(input);
        assertArrayEquals(expected, result, "Already sorted array");
    }

    public static void testReverseOrder() {
        int[] input = {5, 4, 3, 2};
        int[] expected = {2, 3, 4, 5};

        int[] result = sorter.sort(input);
        assertArrayEquals(expected, result, "Reverse order array");
    }

    public static void testSingleElement() {
        int[] input = {10};
        int[] expected = {10};

        int[] result = sorter.sort(input);
        assertArrayEquals(expected, result, "Single element array");
    }

    public static void testEmptyArray() {
        int[] input = {};
        int[] expected = {};

        int[] result = sorter.sort(input);
        assertArrayEquals(expected, result, "Empty array (edge case)");
    }
}

// Main class
public class Task6 {

    public static void main(String[] args) {
        System.out.println("Running Sorting Tests...\n");

        SortUtilsTest.testNormalArray();
        SortUtilsTest.testAlreadySorted();
        SortUtilsTest.testReverseOrder();
        SortUtilsTest.testSingleElement();
        SortUtilsTest.testEmptyArray();
    }
}