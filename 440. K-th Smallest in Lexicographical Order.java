public class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        int cur = 1;
        while (k > 0) {
            int step = stepCount(n, cur, cur + 1);
            if (step > k) {
                cur *= 10;
                k--;
            } else {
                cur++;
                k -= step;
            }
        }
        return cur;
    }
    
    public int stepCount (long target, long left, long right) {
        int step = 0;
        while (left <= target) {
            // target is between the left and right
            if (right > target + 1) {
                step += target - left + 1;
            } else {
                step += right - left;
            }
            left *= 10;
            right *= 10;
        }
        return step;
    }
}
