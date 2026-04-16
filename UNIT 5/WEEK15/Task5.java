import java.util.*;

public class Task5 {

    // Max Subarray Sum (Kadane’s Algorithm)
    public static int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Prefix Sum
    public static int[] prefixSum(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        return prefix;
    }

    // Frequency Count
    public static Map<Integer, Integer> frequencyCount(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        if (nums == null) return freq;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return freq;
    }

    // MAIN METHOD (Execution starts here)
    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Max Subarray Sum
        int maxSum = maxSubarraySum(nums);
        System.out.println("Max Subarray Sum = " + maxSum);

        // Prefix Sum
        int[] prefix = prefixSum(nums);
        System.out.println("Prefix Sum = " + Arrays.toString(prefix));

        // Frequency Count
        Map<Integer, Integer> freq = frequencyCount(nums);
        System.out.println("Frequency Count = " + freq);
    }
}