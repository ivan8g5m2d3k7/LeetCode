class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length + 1;
            int[] minCostAtStep = new int[n];
            minCostAtStep[0] = 0;
            minCostAtStep[1] = 0;
            for (int i = 2; i < n; i++) {
                minCostAtStep[i] = Math.min(minCostAtStep[i - 2] + cost[i - 2], 
                        minCostAtStep[i - 1] + cost[i - 1]);
            }
            
            return minCostAtStep[cost.length];
        }
    }