class Solution {
        public int numRollsToTarget(int n, int k, int target) {
            // dp[i][j] = number of ways to roll i dice that sum to j amount
            int[][] dp = new int[n + 1][target + 1];

            dp[0][0] = 1;

            // for (int d = 1; d <= Math.min(k, target); d++) {
            //     dp[1][d] = 1;
            // }
            int m = (int) Math.pow(10, 9) + 7;


            for (int d = 1; d <= n; d++) {
                for (int s = 1; s <= target; s++) {
                    for (int v = 1; v <= Math.min(k, s); v++) {
                       dp[d][s] = (dp[d][s] + dp[d - 1][s - v]) % m;
                    }
                }
            }

            return dp[n][target];
        }
    }