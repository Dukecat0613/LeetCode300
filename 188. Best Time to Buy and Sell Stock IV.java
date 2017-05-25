public class Solution {
    public int maxProfit(int k, int[] prices) {
        // dp[k][i] represents the max profit until ith by doing k transactions
        // dp[k][i] = max(dp[k - 1][j] + prices[i] - prices[j], dp[k][i - 1]) 0 <= j <= i -1
        int len = prices.length;
        if (k >= len) {
            int profit = 0;
            if (len == 0) {
                return profit;
            }
            for (int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                    
                }
            }
            return profit;
        } else {
              int[][] dp = new int[k + 1][len];
              for (int i = 1; i <= k; i++) {
                  int tmp = dp[i - 1][0] - prices[0];
                  for (int j = 1; j < len; j++) {
                      dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmp);
                      tmp = Math.max(tmp, dp[i - 1][j] - prices[j]);
                  }
              }
              return dp[k][len - 1];
        }
        
    }
} 
