public class programmers468371 {

    /*
    2025 카카오 하반기 1차 > 노란불 신호등
    1. t초가 노란불인지 확인하려면 -> t % (G+Y+R) = 3 % 7 = 3
    2. 최소공배수만큼 확인하면 됨. 그 이후로 넘어가면 -1 리턴.
    3. 브루트포스로 충분히 가능.
    */


    public int solution(int[][] signals) {
        int lcm = 1;    
        for (int[] signal : signals) {
            int total = signal[0] + signal[1] + signal[2];
            lcm = getLcm(lcm, total);
        }
        
        for (int i = 1; i < lcm + 1; i++) {
            boolean flag = true;
            
            for (int[] signal : signals) {
                if (!isYellow(i, signal[0], signal[1], signal[2])) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return i;
            }
        }
        
        
        return -1;
    }
    
    static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    static int getLcm(int a, int b) {
        return a / getGcd(a, b) * b;
    }
    
    static boolean isYellow(int t, int g, int y, int r) {
        int c = t % (g + y + r);
        return c > g && c < g + y + 1; 
    }
}