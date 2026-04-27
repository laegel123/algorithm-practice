import java.util.ArrayList;
import java.util.List;

public class programmers42862 {
    public int solution(int n, int[] lost, int[] reserve) {        
        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        
        for (int r : reserve) {
            if (lostList.contains(r)) {
                lostList.remove((Integer) r);
                reserveList.remove((Integer) r);
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!lostList.contains(i)) {
                count++;
                continue;
            }
            
            int before = i - 1;
            int after = i + 1;
            
            if (reserveList.contains(before) && !lostList.contains(before)) {
                reserveList.remove((Integer) before);
                count++;
            } else if (reserveList.contains(after) && !lostList.contains(after)) {
                reserveList.remove((Integer) after);
                count++;
            }
        }
        
        return count;
    }
}
