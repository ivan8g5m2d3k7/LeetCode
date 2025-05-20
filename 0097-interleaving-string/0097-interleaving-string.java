class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            if (m + n != s3.length()) {
                return false;
            }
            // dp[i][j] = true if the first i+j chars of s3 can be interleaved with the first i chars of s1 
            // and j chars of s2
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
            
            return dp[m][n];
        }
    }