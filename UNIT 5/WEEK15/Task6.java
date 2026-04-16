import java.util.*;

public class Task6 {

    // Max Subarray Sum
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

    // ✅ Manual Test Function (instead of JUnit)
    public static void check(String testName, boolean condition) {
        if (condition) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    public static void main(String[] args) {

        // 🔹 Test 1: Empty Array
        int[] empty = {};
        check("Empty MaxSum", maxSubarraySum(empty) == 0);
        check("Empty Prefix", prefixSum(empty).length == 0);
        check("Empty Frequency", frequencyCount(empty).isEmpty());

        // 🔹 Test 2: Mixed Values
        int[] mixed = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        check("Mixed MaxSum", maxSubarraySum(mixed) == 6);

        int[] prefix = prefixSum(mixed);
        check("Mixed Prefix Last Value", prefix[prefix.length - 1] == 1);

        Map<Integer, Integer> freq = frequencyCount(mixed);
        check("Frequency of 1", freq.get(1) == 2);
        check("Frequency of 4", freq.get(4) == 2);

        // 🔹 Test 3: All Negative
        int[] negative = {-5, -2, -8};
        check("All Negative", maxSubarraySum(negative) == -2);

        // 🔹 Test 4: Large Array (Stress)
        int n = 100000;
        int[] large = new int[n];
        Arrays.fill(large, 1);

        check("Large MaxSum", maxSubarraySum(large) == n);
        check("Large Prefix", prefixSum(large)[n - 1] == n);
        check("Large Frequency", frequencyCount(large).get(1) == n);
    }
}