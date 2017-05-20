public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len  = s.length();
        if (len == 0) return 0;
        // two pointers 
        int head = 1;
        int[] duplicates = new int[256];
        int maxSize = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            // duplicates is beyong current substring
            if (duplicates[tmp] < head) {
                duplicates[tmp] = i+ 1;
                cur++;
                maxSize = Math.max(cur, maxSize);
            } else {
                // duplicates is in the current substring
                // update head and calculate the current size
                cur = i - duplicates[tmp] + 1;
                head = duplicates[tmp] + 1;
                duplicates[tmp] = i + 1;
                maxSize = Math.max(maxSize, cur);
            }
        }
        return maxSize;
    }
}
