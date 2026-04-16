public class Task2 {

    // Method to demonstrate Step Into
    public static int add(int a, int b) {
        int result = a + b;   // Step Into will come here
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9};
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // 👉 Put breakpoint here
            sum = add(sum, nums[i]);  // Step Into / Step Over

        }

        System.out.println("Final Sum = " + sum);
    }
}