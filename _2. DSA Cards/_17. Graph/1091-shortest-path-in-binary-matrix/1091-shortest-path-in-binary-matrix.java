 class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
                return -1;
            }
            boolean[][] visited = new boolean[n][n];
            Deque<Integer[]> queue = new ArrayDeque<>();
            visited[0][0] = true;
            queue.offer(new Integer[]{0, 0});
            int length = 0;

            while (!queue.isEmpty()) {
                length++;
                int size = queue.size();
                Deque<Integer[]> nextQueue = new ArrayDeque<>();

                for (int i = 0; i < size; i++) {
                    Integer[] current = queue.poll();
                    int r = current[0];
                    int c = current[1];
                    if (r == n - 1 && c == n - 1 && grid[r][c] == 0) {
                        return length;
                    }

                    if (isValid(r - 1, c - 1, n, visited, grid)) {
                        visited[r - 1][c - 1] = true;
                        nextQueue.offer(new Integer[]{r - 1, c - 1});
                    }
                    if (isValid(r - 1, c, n, visited, grid)) {
                        visited[r - 1][c] = true;
                        nextQueue.offer(new Integer[]{r - 1, c});
                    }
                    if (isValid(r - 1, c + 1, n, visited, grid)) {
                        visited[r - 1][c + 1] = true;
                        nextQueue.offer(new Integer[]{r - 1, c + 1});
                    }
                    if (isValid(r, c + 1, n, visited, grid)) {
                        visited[r][c + 1] = true;
                        nextQueue.offer(new Integer[]{r, c + 1});
                    }
                    if (isValid(r + 1, c + 1, n, visited, grid)) {
                        visited[r + 1][c + 1] = true;
                        nextQueue.offer(new Integer[]{r + 1, c + 1});
                    }
                    if (isValid(r + 1, c, n, visited, grid)) {
                        visited[r + 1][c] = true;
                        nextQueue.offer(new Integer[]{r + 1, c});
                    }
                    if (isValid(r + 1, c - 1, n, visited, grid)) {
                        visited[r + 1][c - 1] = true;
                        nextQueue.offer(new Integer[]{r + 1, c - 1});
                    }
                    if (isValid(r, c - 1, n, visited, grid)) {
                        visited[r][c - 1] = true;
                        nextQueue.offer(new Integer[]{r, c - 1});
                    }
                }

                queue = nextQueue;
            }

            return -1;
        }

        public boolean isValid(int i, int j, int n, boolean[][] visited, int[][] grid) {
            return (i >= 0 && i < n && j >= 0 && j < n) && (!visited[i][j]) && (grid[i][j] == 0);
        }
    }