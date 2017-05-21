public class Solution {
    public int minArea(char[][] image, int x, int y) {
        // Simple BFS, nothing to explain
        Queue<int[]> queue = new LinkedList<>();
        int m = image.length;
        if(m == 0) return 0;
        int n = image[0].length;
        int left = x;
        int right = x;
        int top = y;
        int bottom = y;
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            if(i < left) left = i;
            if(i > right) right = i;
            if(j < bottom) bottom = j;
            if(j > top) top = j;
            if(i - 1 >= 0 && image[i - 1][j] == '1' && !visited[i-1][j]) {
            	visited[i - 1][j] = true;
                queue.offer(new int[]{i - 1, j});
            }
            if(i + 1 < m && image[i + 1][j] == '1' && !visited[i + 1][j]) {
            	visited[i + 1][j] = true;
                queue.offer(new int[]{i + 1, j});
            }
            if(j - 1 >= 0 && image[i][j - 1] == '1' && !visited[i][j - 1]) {
            	visited[i][j - 1] = true;
                queue.offer(new int[]{i, j - 1});
            }
            if(j + 1 < n && image[i][j + 1]=='1' && !visited[i][j + 1]) {
            	visited[i][j + 1] = true;
                queue.offer(new int[]{i, j + 1});
            }
        }
        return (top - bottom + 1) * (right - left + 1);
    }
}
