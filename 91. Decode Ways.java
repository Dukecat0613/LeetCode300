public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.startsWith("0")) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int tmp1 = Integer.valueOf(s.substring(i - 1, i));
            int tmp2 = Integer.valueOf(s.substring(i - 2, i));
            if (tmp2 <= 26 && tmp2 >= 10) {
                dp[i] += dp[i - 2];
            }
            dp[i] += tmp1 == 0 ? 0 : dp[i - 1];
        }
        return dp[len];
    }
}
