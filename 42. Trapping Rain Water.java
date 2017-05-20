public class Solution {
    public int trap(int[] height) {
        // Trapped water can be decided only if the current height is lower than previous height
        // We use stack
        Stack<Integer> s = new Stack<>();
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!s.isEmpty() && height[s.peek()] < height[i]) {
                int tmp = s.pop();
                if (!s.isEmpty()) {
                    int left = s.peek();
                    res += (Math.min(height[i], height[left]) - height[tmp]) * (i - left - 1);
                }
                
            }
            s.push(i);
        }
        return res;
    }
    // Method2 two pointers
    public int trapMethod2(int[] height) {
        int len = height.length;
        int head = 0;
        int tail = len - 1;
        int moveHead = 0;
        int moveTail = len - 1;
        int res = 0;
        while (moveHead < moveTail) {
            if (height[moveHead] < height[moveTail]) {
                moveHead++;
            } else {
                moveTail--;
            }
            if (height[head] > height[moveHead]) {
                int diff = Math.min(height[head], height[tail]) - height[moveHead];
                res += diff > 0 ? diff : 0;
            } else {
                head = moveHead;
            }
            if (height[tail] > height[moveTail]) {
                int diff = Math.min(height[head], height[tail]) - height[moveTail];
                res += diff > 0 ? diff :0;
            } else {
                tail = moveTail;
            }
        }
        return res;
    }
}
