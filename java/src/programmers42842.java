public class programmers42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        
        for (int h = 1; h * h <= n; h++) {
            if (n % h == 0) {
                int w = n / h;
                
                if ((w - 2) * (h - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return answer;
    }
}
