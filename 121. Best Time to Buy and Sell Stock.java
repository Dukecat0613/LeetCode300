public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
