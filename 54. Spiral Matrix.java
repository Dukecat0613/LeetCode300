public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colBegin = 0;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        List<Integer> res = new ArrayList<>(); 
        if (rowEnd < 0) {
            return res;
        }
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // add right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            // add down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            // add left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // add up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
