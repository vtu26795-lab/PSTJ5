import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

class SortUtils {

    public void sort(int[] arr) {
        Arrays.sort(arr); // fast sorting
    }
}

// Test class
class TimeoutTest {

    static SortUtils sorter = new SortUtils();

    // Manual assertTimeout
    public static void assertTimeout(Duration duration, Runnable method, String testName) {
        long start = System.nanoTime();

        method.run();

        long end = System.nanoTime();

        long elapsedMillis = (end - start) / 1_000_000;

        if (elapsedMillis <= duration.toMillis()) {
            System.out.println("✅ PASS: " + testName + 
                               " (" + elapsedMillis + " ms)");
        } else {
            System.out.println("❌ FAIL: " + testName + 
                               " (" + elapsedMillis + " ms > " + duration.toMillis() + " ms)");
        }
    }

    // Generate large array
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    // Test method
    public static void testSortingTimeout() {
        int[] arr = generateArray(100000);

        assertTimeout(Duration.ofMillis(100), () -> {
            sorter.sort(arr);
        }, "Sorting within 100 ms");
    }
}

// Main class
public class Task3 {

    public static void main(String[] args) {
        System.out.println("Running Timeout Test...\n");
        TimeoutTest.testSortingTimeout();
    }
}