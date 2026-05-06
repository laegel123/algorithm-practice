public class leetcode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n - 1;

        int max = 0;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[end], height[start]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
