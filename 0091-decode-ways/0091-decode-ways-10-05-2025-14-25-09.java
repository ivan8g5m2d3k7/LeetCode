class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= s.length(); i++) {
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1];
                }
                int num = Integer.parseInt(s.substring(i - 2, i));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[dp.length - 1];
        }
    }