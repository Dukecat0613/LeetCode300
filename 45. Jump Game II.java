public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        // dp[i + j]
        int maxReach = 0;
        int frontReach = maxReach;
        // dp[i]
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            int dis = nums[i];
            maxReach = Math.max(maxReach, i + dis);
            if (i == frontReach) {
                step++;
                frontReach = maxReach;
            }
        }    
        return step
        ;
    }
}
