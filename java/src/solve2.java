import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solve2 {
    public int getNumber(int[] nums) {

        int result = 0;
        int maxCount = 0;
        int[] arr = new int[10001];

        for (int num : nums) {
            arr[num]++;
            if (maxCount < arr[num]) {
                result = num;
                maxCount = arr[num];
            }
        }


        return result;
    }

    public int getNumber2(int[] nums) {

        int result = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (maxCount < map.get(num)) {
                result = num;
                maxCount = map.get(num);
            }
        }

        return result;
    }

    public int getFirstIndex(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }


        return -1;
    }

    public int getSecondBiggestNumber(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (set.size() == 1) return -1;
        
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax) {
                secondMax = n;
            }
        }

        return secondMax;
    }

    public boolean getExistSumZeroNumber(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == 0) return true;
            
            if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }

        return false;
    }
}
