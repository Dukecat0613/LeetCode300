public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for (int[] tmp : ops) {
            if(tmp[0] < row) {
                row = tmp[0];
            }
            if (tmp[1] < col) {
                col = tmp[1];
            }
        }
        return row * col;
    }
}
