public class Solution {
    public int maxCoins(int[] nums) {
    // Classic DP problem
        int l = nums.length;
        int[][] dp = new int[l][l];
        
        for (int len = 1; len <= l; len++) {
            for (int left = 0; left + len <= l; i++) {
                int right = len + left - 1;
                for (int i = left; i < left + len; i++) {
                    int leftPart = 0;
                    int rightPart = 0;
                    if (i - 1 >= left) {
                        leftPart = dp[left][i - 1];
                    }
                    if (i + 1 <= right) {
                        rightPart = dp[i + 1][right];
                    }
                    int leftBoundary = 1;
                    int rightBoundary = 1;
                    if (left > 0) {
                        leftBoundary = nums[left - 1];
                    }
                    if (right < nums.length - 1) {
                        rightBoundary = nums[right + 1];
                    }
                    dp[left][right] = Math.max(dp[left][right], leftBoundary * nums[i] * rightBoundary + leftPart + rightPart);
                }
            }
        }
        return dp[0][l - 1];
    }
}
