public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> profitPq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        PriorityQueue<int[]> capitalPq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int res = W;
        int len = Profits.length;
        if (len == 0) {
            return res;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            capitalPq.offer(new int[]{Capital[i], Profits[i]}); 
        }
        
        while (k-- > 0) {
            while (!capitalPq.isEmpty() && capitalPq.peek()[0] <= W) {
                profitPq.offer(capitalPq.poll());
            }
            if (profitPq.isEmpty()) {
                return res;
            }
            int profit = profitPq.poll()[1];
            res += profit;
            W += profit;
            
        }
        return res;
    }
}
