import java.util.Arrays;

public class leetcode268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        if (nums[0] != 0) return 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - 1 != nums[i - 1]) return nums[i] - 1;
        }

        return n;
    }
}
