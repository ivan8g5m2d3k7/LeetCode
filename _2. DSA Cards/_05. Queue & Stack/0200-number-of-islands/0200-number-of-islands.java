class Solution {
    public int numIslands(char[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }

                    count++;
                    Deque<Integer> queue = new LinkedList<>();
                    queue.offer(i * n + j);
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int cell = queue.poll();
                        int row = cell / n;
                        int col = cell % n;

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer((row - 1) * n + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            queue.offer((row + 1) * n + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(row * n + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            queue.offer(row * n + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }

            return count;
        }
}