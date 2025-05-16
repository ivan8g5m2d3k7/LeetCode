public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp[i] = min cost to cover all travel days starting from days[i]
        Integer[] memo = new Integer[days.length];
        return dp(0, days, costs, memo);
    }

    private int dp(int i, int[] days, int[] costs, Integer[] memo) {
        // Base case: no more days to cover
        if (i >= days.length) {
            return 0;
        }

        // Memoization check
        if (memo[i] != null) {
            return memo[i];
        }

        int n = days.length;

        // Option 1: Buy 1-day pass
        int j = i;
        while (j < n && days[j] < days[i] + 1) {
            j++;
        }
        int cost1 = costs[0] + dp(j, days, costs, memo);

        // Option 2: Buy 7-day pass
        j = i;
        while (j < n && days[j] < days[i] + 7) {
            j++;
        }
        int cost7 = costs[1] + dp(j, days, costs, memo);

        // Option 3: Buy 30-day pass
        j = i;
        while (j < n && days[j] < days[i] + 30) {
            j++;
        }
        int cost30 = costs[2] + dp(j, days, costs, memo);

        // Take the minimum of the three options
        int minCost = Math.min(cost1, Math.min(cost7, cost30));
        memo[i] = minCost;
        return minCost;
    }
}