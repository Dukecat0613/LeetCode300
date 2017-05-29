public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (len - mid < citations[mid]) {
                right = mid - 1;
            } else if (len - mid == citations[mid]) {
                return citations[mid];
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
