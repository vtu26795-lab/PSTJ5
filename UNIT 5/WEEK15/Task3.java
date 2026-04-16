public class Task3 {

    public static void main(String[] args) {

        int[] nums = {2, 4, 6, 8, 10};
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {   // ✅ FIXED (< instead of <=)

            // 👉 Set CONDITIONAL BREAKPOINT: i == 3 (example)
            sum += nums[i];
        }

        System.out.println("Sum = " + sum);
    }
}