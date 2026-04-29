public class programmers43165 {
    int COUNT = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return COUNT;
    }
    
    public void dfs(int[] numbers, int cur, int target, int idx) {
        if (idx == numbers.length) {
            if (cur == target) {
                COUNT++;
            }
            return;
        }
        
        dfs(numbers, cur + numbers[idx], target, idx + 1);
        dfs(numbers, cur - numbers[idx], target, idx + 1);
    }
}
