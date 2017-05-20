public class Solution {
    public boolean isMatch(String s, String p) {
        //DP
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = boolean int[sLen + 1 ][pLen + 1];
        for (int i = pLen - 1; i >= 0 ; i--) {
            if (p.charAt(i) == '*') {
                dp[sLen][i] = true;
            } else {
                break;
            }
        }
       for (int i = sLen - 1; i >=0; i--) {
           for (int j = pLen - 1; j >= 0; j--) {
               if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
				   dp[i][j] = dp[i + 1][j + 1];
               } else if (p.charAt(j) == '*') {
			       dp[i][j] = dp[i + 1][j + 1] || dp[i + 1][j] || dp[i][j + 1];
			   } else {
                   dp[i][j] = false;
               }
           }
       } 
       return dp[0][0];
    }
}
