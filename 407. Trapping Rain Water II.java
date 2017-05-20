public class Solution {
    public int trapRainWater(int[][] heightMap) {
        //Form a circle and everytime pop up the minimum height
        // Heap
        int n = heightMap.length;
        if (n == 0) {
            return 0;
        }
        int m = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        boolean[][] visited = new boolean[n][m];
        // add edges
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, m - 1, heightMap[i][m - 1]});
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{n - 1, j, heightMap[n - 1][j]});
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }
        int res = 0;
        // BFS find inner minimum
        while (!pq.isEmpty()) {
            int tmp[] = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            int height = tmp[2];
            if (x + 1 < n && !visited[x + 1][y]) {
                if (heightMap[x + 1][y] < height) {
                    res += height - heightMap[x + 1][y];
                    pq.offer(new int[]{x + 1, y, height});
                } else {
                    pq.offer(new int[]{x + 1, y, heightMap[x + 1][y]});
                }
                visited[x + 1][y] = true;
            }
            if (y + 1 < m && !visited[x][y + 1]) {
                if (heightMap[x][y + 1] < height) {
                    res += height - heightMap[x][y + 1];
                    pq.offer(new int[]{x, y + 1, height});
                } else {
                    pq.offer(new int[]{x, y + 1, heightMap[x][y + 1]});
                }
                visited[x][y + 1] = true;
            }
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                if (heightMap[x - 1][y] < height) {
                    res += height - heightMap[x - 1][y];
                    pq.offer(new int[]{x - 1, y, height});
                } else {
                    pq.offer(new int[]{x - 1, y, heightMap[x - 1][y]});
                }
                visited[x - 1][y] = true;
            }
            if (y - 1 >=0 && !visited[x][y - 1]) {
                if (heightMap[x][y - 1] < height) {
                    res += height - heightMap[x][y - 1];
                    pq.offer(new int[]{x, y - 1, height});
                } else {
                    pq.offer(new int[]{x, y - 1, heightMap[x][y - 1]});
                }
                visited[x][y - 1] = true;
            }
        }
        return res;
    }
}
