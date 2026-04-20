public class programmers86491 {
    public int solution(int[][] sizes) {
        int left = 0;
        int right = 0;
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                left = Math.max(left, size[0]);
                right = Math.max(right, size[1]);
            } else {
                left = Math.max(left, size[1]);
                right = Math.max(right, size[0]);
            }
        }
        
        return left * right;
    }
}
