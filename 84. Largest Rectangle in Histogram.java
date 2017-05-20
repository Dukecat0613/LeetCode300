public class Solution {
    public int largestRectangleArea(int[] heights) {
        // Similiar idea with trapping water
        Stack<Integer> s = new Stack()<>();
        int max = 0;
        int len = heights.length;
        
        for (int i = 0; i < len; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                int tmp = s.pop();
                int left = s.isEmpty() ? 0 : s.peek() + 1;
                max = Math.max(max, heights[tmp] * (i - left));
            }
        }
        while (!s.isEmpty() && heights[s.peek()] >= 0) {
            int tmp = s.pop();
            int left = s.isEmpty() ? 0 : s.peek() + 1;
            max = Math.max(max, heights[tmp] * (len - left));
        }
        return max;
    }
}
