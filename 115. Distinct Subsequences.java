public class Solution {
    public int numDistinct(String s, String t) {
        /* dp[i][j] means s[0...j] &&t[0...i] contains times of distinct subsequences */
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        /* dp[0][j]=1 because empty string is the subsequence of any string */
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = 1;
        }
        
        /* fill the whole dp */
        
        for(int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j]; /* both s,t go back a char and s go back a char */
                }
                else {
                    dp[i + 1][j + 1] = dp[i + 1][j];                   /* nothing new */
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
