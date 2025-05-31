class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2]; // memo[day][holding = 0/1]
        return dfs(0, 0, prices, fee, memo);
    }

    // i = current day, holding = 0 (no stock), 1 (holding stock)
    private int dfs(int i, int holding, int[] prices, int fee, Integer[][] memo) {
        if (i == prices.length) return 0;

        if (memo[i][holding] != null) return memo[i][holding];

        int doNothing = dfs(i + 1, holding, prices, fee, memo);

        if (holding == 1) {
            // Option to sell
            int sell = prices[i] - fee + dfs(i + 1, 0, prices, fee, memo);
            memo[i][holding] = Math.max(doNothing, sell);
        } else {
            // Option to buy
            int buy = -prices[i] + dfs(i + 1, 1, prices, fee, memo);
            memo[i][holding] = Math.max(doNothing, buy);
        }

        return memo[i][holding];
    }
}