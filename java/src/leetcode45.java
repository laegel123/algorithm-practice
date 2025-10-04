/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-03
 */
public class leetcode45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    public static int jump(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if (count[i + j] != 0) {
                        count[i + j] = Math.min(count[i] + 1, count[i + j]);
                    } else {
                        count[i + j] = count[i] + 1;
                    }
                }
            }
        }

        return count[nums.length - 1];
    }
}
