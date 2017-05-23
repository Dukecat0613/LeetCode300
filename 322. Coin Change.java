public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] CC = new int[amount + 1];
        Arrays.fill(CC, -1);
        CC[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    if (CC[i - coins[j]] < min && CC[i - coins[j]] != -1) {
                        min = CC[i - coins[j]] + 1;
                        CC[i] = min;
                    }
                }
            }
            
        }
        return CC[amount];
    }
}
