public class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] s = new int[n + 1];
        s[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            s[i] = nums[i - 1] + s[i - 1];
        }
        // dp[i][j] represents the min(max subarray) of spliting 0 - j by i subarraies
        // dp[i][j] = min(dp[i - 1][k], sum(k - j)) i -1 <= k < j
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], s[j] - s[k]));
                }
            }
        }
        return dp[m][n];
    }
}
