public class Solution {
    public int maxArea(int[] height) {
        // two pointers
        int len = height.length;
        int head = 0;
        int tail = len - 1;
        int max = 0;
        while (head < tail) {
            max = Math.max(max, Math.min(height[head], height[tail]) * (tail - head));
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return max;
    }
}
