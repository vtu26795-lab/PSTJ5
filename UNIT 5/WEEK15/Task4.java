public class VariableTrackingFixed {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // 👉 Put breakpoint here to track values
            sum += nums[i];

            // Optional print (for understanding)
            System.out.println("Step " + i + ": sum = " + sum);
        }

        System.out.println("Final Sum = " + sum);
    }
}