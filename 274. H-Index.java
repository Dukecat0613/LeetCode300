public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        
        int[] bucket = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                bucket[len]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        
        int res = 0;
        int i = len;
        for (; i >= 0; i--) {
            res += bucket[i];
            if (res >= i) {
                return i;
            }
        }
        return 0;
    }
}
