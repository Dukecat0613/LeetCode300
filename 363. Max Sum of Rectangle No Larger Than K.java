public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //a matrix is decided by left right up and bottom boundary
        // We scan from left to right, during the process using treeSet to find the largest matrix
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < m; i++) {
            int[] vertical = new int[n];
            for (int right = i; right < m; right++) {
                for (int j = 0; j < n; j++){
                    vertical[j] += matrix[i][right];
                }
                TreeSet<Integer> s = new TreeSet<>();
                int sum = 0;
                // critical point
                s.add(0);
                for (int j = 0; j < n; j++) {
                    sum += vertical[j];
                    Integer maxSum = s.ceiling(sum - k);
                    if (maxSum != null) {
                        max = Math.max(max, sum - maxSum);
                    }
                    s.add(sum);
                }
            }
        }
        return max;
    }
}
