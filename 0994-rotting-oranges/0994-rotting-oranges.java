class Solution {
        public int orangesRotting(int[][] grid) {
            int[][] directions = new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            int minutes = -1;
            Deque<Integer[]> queue = new ArrayDeque<>();
            int m = grid.length;
            int n = grid[0].length;
            int countFresh = 0;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new Integer[] {i, j});
                    } else if (grid[i][j] == 1) {
                        countFresh++;
                    }
                }
            }

            if (countFresh == 0) {
                return 0;
            }

            while (!queue.isEmpty()) {
                Deque<Integer[]> nextQueue = new ArrayDeque<>();
                int size = queue.size();
                minutes++;

                for (int c = 0; c < size; c++) {
                    Integer[] cell = queue.poll();
                    int i = cell[0];
                    int j = cell[1];

                    grid[i][j] = 2;
                    if (minutes > 0) {
                        countFresh--;
                    }

                    for (int d = 0; d < directions.length; d++) {
                        int row = i + directions[d][0];
                        int col = j + directions[d][1];
                        if (row >= 0 && row < m && col >= 0 && col < n &&
                                grid[row][col] == 1 && !visited[row][col]) {
                            nextQueue.offer(new Integer[] {row, col});
                            visited[row][col] = true;
                        }
                    }
                }

                queue = nextQueue;
            }

            return countFresh == 0 ? minutes : -1;
        }
    }