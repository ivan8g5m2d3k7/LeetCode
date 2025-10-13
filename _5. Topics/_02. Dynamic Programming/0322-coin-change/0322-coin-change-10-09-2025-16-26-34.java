class Solution {
        public int coinChange(int[] coins, int amount) {
            long[] dp = new long[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int coin : coins) {
                for (int a = 1; a <= amount; a++) {
                    if (a - coin >= 0 && dp[a - coin] != -1) {
                        dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                    }
                }
            }

            return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
        }
    }