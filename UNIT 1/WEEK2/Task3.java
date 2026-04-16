import java.util.*;

public class Task3 {

    static void miniMaxSum(int[] arr) {
        long total = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int num : arr) {
            total += num;
        }

        for (int num : arr) {
            long sum = total - num;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        miniMaxSum(arr);
    }
}