public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        int len = machines.length;
        if (len == 0) {
            return 0;
        }
        
        for (int i = 0; i < len; i++) {
            sum += machines[i];
        }
        
        if (sum % len != 0) return -1;
        int avg = sum/len;
        int max = -1;
        int load = 0;
        for (int i = 0; i < len; i++) {
            load += (machines[i] - avg);
            max = Math.max(Math.max(max, Math.abs(load)), machines[i] - avg);
        }
        return max;
    }
}
