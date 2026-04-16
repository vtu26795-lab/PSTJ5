import java.util.*;

public class TimeTest {

    public static void main(String[] args) {

        int size = 100000;
        int[] arr = new int[size];
        Random rand = new Random();

        // Fill array
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Start time
        long startTime = System.currentTimeMillis();

        // Code to measure (sorting)
        Arrays.sort(arr);

        // End time
        long endTime = System.currentTimeMillis();

        // Calculate time
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}