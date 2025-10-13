class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if ((sum & 1) != 0) {
                return false;
            }
            int target = sum / 2;

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            
            for (int num : nums) {
                for (int s = sum; s >= num; s--) {
                    dp[s] = dp[s] || dp[s - num];
                }
            }
            
            return dp[target];
        }
    }