class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            // dp[i][j] - sum to reach cell [i][j]
            int[][] dp = new int[n][n];
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int prev = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        prev = dp[i - 1][j - 1];
                    }
                    prev = Math.min(prev, dp[i - 1][j]);
                    if (j + 1 < n) {
                       prev = Math.min(prev, dp[i - 1][j + 1]);
                    }

                    dp[i][j] = prev + matrix[i][j];
                }
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[n - 1][j]);
            }

            return min;
        }
    }