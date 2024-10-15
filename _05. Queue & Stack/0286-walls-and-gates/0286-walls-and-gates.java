class Solution {
    private static final int WALL = -1;
        private static final int GATE = 0;
        private static final int EMPTY = Integer.MAX_VALUE;

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            int n = rooms[0].length;
            int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Deque<Integer[]> queue = new ArrayDeque<>();
            
            for (int i = 0; i <m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == GATE) {
                        for (int[] direction : directions) {
                            int row = i + direction[0];
                            int col = j + direction[1];
                            if (row < 0 || row >= m || col < 0 || col >= n) {
                                continue;
                            }

                            if (rooms[row][col] == EMPTY) {
                                queue.add(new Integer[]{row, col});
                                rooms[row][col] = 1;
                            }
                        }
                    }
                }
            }
            
            while (!queue.isEmpty()) {
                Integer[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                int dist = rooms[i][j] + 1;
                
                for (int[] direction : directions) {
                    int row = i + direction[0];
                    int col = j + direction[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) {
                        continue;
                    }

                    if (rooms[row][col] == EMPTY) {
                        queue.add(new Integer[]{row, col});
                        rooms[row][col] = dist;
                    }
                }
            }
        }
}