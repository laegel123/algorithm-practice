/**
 * @author laegel
 * @version 1.0
 * @since 2025-10-13
 */
public class leetcode55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            int availableJump = nums[idx];
            if (idx + availableJump >= nums.length - 1) {
                return true;
            }
            if (availableJump == 0) {
                return false;
            }

            int nextIdx = idx;
            for (int i = 1; i <= availableJump; i++) {
                if (i == 1) {
                    nextIdx++;
                    continue;
                }
                if (idx + i + nums[idx + i] > nextIdx + nums[nextIdx]) {
                    nextIdx = idx + i;
                }
            }

            idx = nextIdx;
        }

        return true;
    }
}
