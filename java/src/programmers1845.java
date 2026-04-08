public class programmers1845 {
    public int solution(int[] nums) {
        int answer = 0;
        
        int n = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                answer++;
                set.add(nums[i]);
            }
            
            if (answer >= n) break;
        }
        
        return answer;
    }
}