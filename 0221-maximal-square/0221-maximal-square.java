class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            // dp[i][j] -> the diagonal length of the largest square
            // whose right-bottom corner is at matrix[i][j]
            int[][] dp = new int[m][n];
            int max = -1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = -1;
                    if (matrix[i][j] == '0') {
                        val = 0;
                    } else if (i - 1 >= 0 && j - 1 >= 0) {
                        val = Math.min(dp[i - 1][j -1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    } else {
                        val = 1;
                    }

                    dp[i][j] = val;
                    max = Math.max(max, val);
                }
            }

            return max * max;
        }
    }