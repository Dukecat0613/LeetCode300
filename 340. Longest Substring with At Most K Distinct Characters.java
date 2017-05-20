public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len <= k) {
            return len;
        }
        if (k == 0) return 0;
        // two pointers;
        int head = 0;
        int[] map = new int[256];
        int distinctNum = 0;
        int maxSize = 0;
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if (map[tmp]++ == 0) {
                distinctNum++;
            }
            if (distinctNum > k) {
                while (--map[s.charAt(head++)] > 0) {}
                distinctNum--;
            }
            maxSize = Math.max(maxSize, i - head + 1);
        }
        return maxSize;
    }
}
