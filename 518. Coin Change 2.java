public class Solution {
    public int change(int amount, int[] coins) {
        // DP
        // dp[i][j] represents amount i and coins 0-j can have dp[i][j] ways of change
        // dp[i][j] = dp[i][j] + dp[i][j-1]
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; i <= coins.length; j++) {
                if (i >= coins[j - 1]) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
                // either include the current coin or not include
                dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[amount][coins.length];
    }
}
