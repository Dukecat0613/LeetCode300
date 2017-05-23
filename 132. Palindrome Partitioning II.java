public class Solution {
    public int minCut(String s) {
        // dp[i][j] represent whether i-j can form a palindrome
        // if charAt(i) == charAt(j) dp[i][j] = dp[i + 1][j - 1]
        // if dp[i][j] == true; if i == 0; corresponding cur is 0
        //                      else min();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] dpCut = new int[len];
        
        for (int j = 0; j < len; j++) {
            dpCut[j] = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    if (i == 0) {
                        dpCut[j] = 0;
                    } else {
                        dpCut[j] = Math.min(dpCut[j], dpCut[i - 1] + 1);   
                    }
                }
            }
        }
        return dpCut[len - 1];
    }
}
