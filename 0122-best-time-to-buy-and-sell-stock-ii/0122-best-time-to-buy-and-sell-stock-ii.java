 class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] stock = new int[n];
            int[] noStock = new int[n];
            stock[0] = -prices[0];
            for (int i = 1; i < n; i++) {
                stock[i] = Math.max(stock[i - 1], noStock[i - 1] - prices[i]);
                noStock[i] = Math.max(noStock[i - 1], stock[i - 1] + prices[i]);
            }
            return noStock[n - 1];
        }
    }