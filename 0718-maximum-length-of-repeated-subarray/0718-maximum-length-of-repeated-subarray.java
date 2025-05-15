class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int max = 0;
            // dp[i][j] = max length k of common subarray for nums1[0..i], nums2[0..j] - nums1[i-k..i], nums2[j-k..j]
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }

            return max;
        }
    }