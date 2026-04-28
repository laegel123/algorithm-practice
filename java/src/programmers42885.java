import java.util.Arrays;

public class programmers42885 {
    public int solution(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = n - 1;
        int boats = 0;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                boats++;
            } else {
                right--;
                boats++;
            }
        }
        
        return boats;
    }
}
