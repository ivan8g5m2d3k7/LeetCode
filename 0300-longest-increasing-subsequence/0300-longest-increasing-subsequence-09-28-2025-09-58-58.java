class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int longest = 1;
            // dp[i] is the length of LIS that starts at nums[0] and ends at nums[i]
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        
                    }
                }
                longest = Math.max(longest, dp[i]);
            }
            
            return longest;
        }
    }