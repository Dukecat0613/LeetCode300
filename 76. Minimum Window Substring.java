public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int count = t.length();
        int head = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (min > i - head + 1) {
                    min = i - head + 1;
                    index = head;
                }
                if (map[s.charAt(head++)]++ >= 0) {
                    count++;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(index, index + min);
        }
    }
}
