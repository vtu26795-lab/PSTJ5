public class Task1 {

    // Method to calculate sum of array elements
    public static int calculateSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // correct accumulation
        }

        return sum;
    }

    public static void main(String[] args) {

        // Test input
        int[] numbers = {1, 2, 3, 4, 5};

        int result = calculateSum(numbers);

        // Output result
        System.out.println("Sum = " + result);
    }
}