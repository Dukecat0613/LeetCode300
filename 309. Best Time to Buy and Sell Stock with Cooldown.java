public class Solution {
    public int maxProfit(int[] prices) {
        // state machine
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] s0 = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[len - 1], s2[len - 1]);
    }
}
