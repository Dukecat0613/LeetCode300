public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        // two pointers
        int head = 0;
        int maxSize = 0;
        int[] map = new int[256];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, ++map[s.charAt(i)]);
            while (i - head + 1 > max + k) {
                --map[s.charAt(head++)];
            }
            maxSize = Math.max(maxSize, i - head + 1);
        }
        return maxSize;
    }
}
