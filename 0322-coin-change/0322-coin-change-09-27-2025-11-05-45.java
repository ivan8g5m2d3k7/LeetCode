class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int count = 0;

            Arrays.sort(coins);
            // min number of coins that make up amount dp[i]
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int coin : coins) {
                for (int sum = 1; sum <= amount; sum++) {
                    if (sum - coin >= 0) {
                        dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                    }
                }
            }

            return dp[amount] <= amount ? dp[amount] : -1;
        }
    }