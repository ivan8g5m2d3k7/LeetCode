class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int len1 = s1.length();
            int len2 = s2.length();
            int len3 = s3.length();
            if (len1 + len2 != len3) {
                return false;
            }
            if (len2 > len1) {
                return isInterleave(s2, s1, s3);
            }

            boolean[] dp = new boolean[len2 + 1];
            dp[0] = true;

            for (int j = 1; j <= len2; j++) {
                dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            }

            for (int i = 1; i <= len1; i++) {
                dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                for (int j = 1; j <= len2; j++) {
                    boolean fromLeft = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    boolean fromUp = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    dp[j] = fromLeft || fromUp;
                }
            }

            return dp[len2];
        }
    }