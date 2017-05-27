public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        if (n == 0) {
            return 0;
        }
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m- 1 && i == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (j == m -1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}
