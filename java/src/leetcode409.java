public class leetcode409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (Character c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean isMore = false;

        for (int x : count) {
            if (x % 2 == 0) {
                length += x;
            } else {
                length += x - 1;
                isMore = true;
            }
        }

        if (isMore) length++;

        return length;
    }
}
