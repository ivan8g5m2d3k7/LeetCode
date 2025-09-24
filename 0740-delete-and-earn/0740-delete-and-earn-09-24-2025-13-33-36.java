class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = Arrays.stream(nums).max().orElse(-1);
            int[] points = new int[max + 1];
            for (int num : nums) {
                points[num] += num;
            }
            // max points using values 1...i and their points
            int[] dp = new int[max + 1];
            dp[1] = points[1];
            
            for (int i = 2; i <= max; i++) {
                dp[i] = Math.max(dp[i - 2] + points[i], dp[i - 1]);
            }
            return dp[max];
        }
    }