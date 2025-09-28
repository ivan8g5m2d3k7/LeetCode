class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            // dp[i][j] -> min total cost if house i is painted with color j
            int[][] dp = new int[n][3];

            for (int j = 0; j < 3; j++) {
                dp[0][j] = costs[0][j];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    int cost = costs[i][j];
                    if (j == 0) {
                        cost += Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
                    } else if (j == 1) {
                        cost += Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                    } else {
                        cost += Math.min(dp[i - 1][j - 1], dp[i - 1][j - 2]);
                    }
                    
                    dp[i][j] = cost;
                }
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[n - 1][j]);
            }

            return min;
        }
    }