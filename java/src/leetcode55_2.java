/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-13
 */
public class leetcode55_2 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}
