public class MaxSubarraySum {
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = nums[0];   // Initialize with first element
        int currentMax = nums[0]; // Current running sum

        for (int i = 1; i < nums.length; i++) {
            // Either extend the current sub array or start a new one
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }


    public static void main(String[] args) {
        int[] arr = {-1,-2,7};
        System.out.println("Maximum Sub array Sum is: " + maxSubArraySum(arr));
    }
}