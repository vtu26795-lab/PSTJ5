import java.time.Duration;
import java.util.Random;
import java.util.Arrays;

class CompareAlgorithms {

    // 🔴 Slow Algorithm (Bubble Sort)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 🟢 Optimized Algorithm (Arrays.sort)
    public static void fastSort(int[] arr) {
        Arrays.sort(arr);
    }

    // Generate random array
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }

    // Measure execution time
    public static long measureTime(Runnable method) {
        long start = System.nanoTime();
        method.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // ms
    }

    // Manual assertTimeout
    public static void assertTimeout(Duration duration, Runnable method, String testName) {
        long time = measureTime(method);

        if (time <= duration.toMillis()) {
            System.out.println("✅ PASS: " + testName + " (" + time + " ms)");
        } else {
            System.out.println("❌ FAIL: " + testName + " (" + time + " ms)");
        }
    }
}

// Main class
public class Task4{

    public static void main(String[] args) {

        int size = 10000; // reduce size for bubble sort safety

        System.out.println("Comparing Slow vs Fast Algorithm...\n");

        int[] arr1 = CompareAlgorithms.generateArray(size);
        int[] arr2 = arr1.clone(); // same data

        // 🔴 Slow algorithm test
        long slowTime = CompareAlgorithms.measureTime(() -> {
            CompareAlgorithms.bubbleSort(arr1);
        });

        System.out.println("🔴 Bubble Sort Time: " + slowTime + " ms");

        // 🟢 Fast algorithm test
        long fastTime = CompareAlgorithms.measureTime(() -> {
            CompareAlgorithms.fastSort(arr2);
        });

        System.out.println("🟢 Fast Sort Time: " + fastTime + " ms");

        // Timeout test
        CompareAlgorithms.assertTimeout(Duration.ofMillis(100), () -> {
            CompareAlgorithms.fastSort(arr2);
        }, "Fast sort within 100 ms");

        System.out.println("\nPerformance Comparison:");

        if (fastTime < slowTime) {
            System.out.println("✅ Optimized algorithm is faster");
        } else {
            System.out.println("❌ Slow algorithm performed better (unexpected)");
        }
    }
}