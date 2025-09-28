 class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            Integer[][] memo = new Integer[m][n];
            if (obstacleGrid[0][0] == 0) {
                memo[0][0] = 1;
            } else {
                memo[0][0] = 0;
                return 0;
            }
            
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    memo[i][0] = memo[i - 1][0];
                } else {
                    memo[i][0] = 0;
                }
            }
            
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[0][j] == 0) {
                    memo[0][j] = memo[0][j - 1];
                } else {
                    memo[0][j] = 0;
                }
            }
            
            return traverse(obstacleGrid, memo, m, n, m - 1, n - 1);
        }

        public int traverse(int[][] grid, Integer[][] memo, int m, int n, int i, int j) {
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            
            if (grid[i][j] == 1) {
                memo[i][j] = 0;
                return 0;
            }

            int num = traverse(grid, memo, m, n, i - 1, j) + traverse(grid, memo, m, n, i, j - 1);
            memo[i][j] = num;
            return num;
        }
    }