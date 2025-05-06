class Solution {
        public int maxProfit(int[] prices) {
            int low = prices[0];
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max, prices[i] - low);
                low = Math.min(low, prices[i]);
            }
            return max;
        }
    }