/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-13
 */
public class leetcode53 {
    public static void main(String[] args) {
        int maxSum = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(maxSum);
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int subSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (nums[i] > maxSum) {
                    maxSum = nums[i];
                    continue;
                }
                else if (nums[i] > subSum + nums[i]) {
                    subSum = nums[i];
                    continue;
                }

            }
            subSum += nums[i];
            if (subSum < 0)  {
                subSum = 0;
                continue;
            }
            if (subSum > maxSum) maxSum = subSum;
        }

        return maxSum;
    }
}
