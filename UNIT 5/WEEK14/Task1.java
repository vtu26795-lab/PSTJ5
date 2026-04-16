import java.util.*;

class LargeSortTest {

    // Generate large array (100000 elements)
    public static int[] generateLargeArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000); // random values
        }
        return arr;
    }

    // Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Test method
    public static void testLargeSort() {
        int size = 100000; // 10^5
        System.out.println("Generating array of size: " + size);

        int[] arr = generateLargeArray(size);

        long startTime = System.currentTimeMillis();

        Arrays.sort(arr); // Efficient sorting

        long endTime = System.currentTimeMillis();

        // Validate
        if (isSorted(arr)) {
            System.out.println("✅ PASS: Array is sorted correctly");
        } else {
            System.out.println("❌ FAIL: Sorting incorrect");
        }

        System.out.println("⏱ Time taken: " + (endTime - startTime) + " ms");
    }
}

// Main class
public class Task1 {

    public static void main(String[] args) {
        System.out.println("Running Large Array Sorting Test...\n");
        LargeSortTest.testLargeSort();
    }
}