class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 1) {
                return 0;
            } else if (n == 2) {
                if (prices[0] > prices[1]) {
                    return 0;
                } else {
                    return prices[1] - prices[0];
                }
            }

            int[] minToIndex = new int[n];
            int[] maxAfterIndex = new int[n];
            minToIndex[n - 1] = prices[n - 1];
            maxAfterIndex[n - 1] = prices[n - 1];
            maxAfterIndex[n - 2] = prices[n - 1];
            minToIndex[0] = prices[0];

            for (int i = 1; i < n - 1; i++) {
                minToIndex[i] = Math.min(prices[i], minToIndex[i - 1]);
            }
            for (int i = n - 3; i >= 0; i--) {
                maxAfterIndex[i] = Math.max(prices[i + 1], maxAfterIndex[i + 1]);
            }

            int num = 0;
            for (int i = 0; i < n; i++) {
                num = Math.max(num, maxAfterIndex[i] - minToIndex[i]);
            }

            return num;
        }
    }