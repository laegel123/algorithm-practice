/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-13
 */
public class leetcode53_2 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int subSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            subSum = Math.max(nums[i], subSum + nums[i]);
            maxSum = Math.max(maxSum, subSum);
        }

        return maxSum;
    }
}
