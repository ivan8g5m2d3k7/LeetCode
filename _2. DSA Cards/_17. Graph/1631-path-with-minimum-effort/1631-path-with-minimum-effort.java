class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            boolean[][] visited = new boolean[m][n];
            int[][] effort = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    effort[i][j] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            minHeap.offer(new Integer[] {0, 0, 0});
            effort[0][0] = 0;
            int[][] directions = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

            while (!minHeap.isEmpty()) {
                Integer[] a = minHeap.poll();
                int r = a[0], c = a[1], dist = a[2];
                if (visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                if (r == m - 1 && c == n - 1) {
                    return dist;
                }

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    int w = Math.max(dist, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (!visited[nr][nc] && w <= effort[nr][nc]) {
                        effort[nr][nc] = w;
                        minHeap.offer(new Integer[] {nr, nc, w});
                    }
                }
            }

            return effort[m - 1][n - 1];
        }
    }
