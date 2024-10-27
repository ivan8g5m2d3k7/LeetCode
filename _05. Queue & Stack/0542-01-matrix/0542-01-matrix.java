class Solution {
    public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
//            int[][] res = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            Deque<Integer> queue = new ArrayDeque<>();
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                    res[i][j] = mat[i][j];
                    if (mat[i][j] == 0) {
                        visited[i][j] = true;
                        queue.offer(i * n + j);
                    }
                }
            }

            int dist = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> nextQueue = new ArrayDeque<>();
                for (int q = 0; q < size; q++) {
                    int cell = queue.poll();
                    int i = cell / n;
                    int j = cell % n;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dirs[d][0];
                        int nj = j + dirs[d][1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
//                            res[ni][nj] = res[i][j] + 1;
                            mat[ni][nj] = mat[i][j] + 1;
                            visited[ni][nj] = true;
                            nextQueue.offer(ni * n + nj);
                        }
                    }
                }

                dist++;
                queue = nextQueue;
            }

//            return res;
            return mat;
        }
}