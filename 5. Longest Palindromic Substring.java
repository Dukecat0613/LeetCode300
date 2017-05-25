public class Solution {
    public String longestPalindrome(String s) {
        //DP   
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int max = 0;
        String res = "";
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i -1])) {
                    dp[j][i] = true;
                    if (dp[j][i]) {
                        if (i - j + 1 > max) {
                            res = s.substring(j, i + 1);
                            max = i - j + 1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
