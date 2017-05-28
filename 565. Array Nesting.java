public class Solution {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            int index = i;
            int length = 0;
            while (!visited[index]) {
                visited[index] = true;
                index = nums[index];
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
