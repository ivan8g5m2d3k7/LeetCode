class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (String word : wordDict) {
                    if (i >= word.length() && s.startsWith(word, i - word.length())
                    && dp[i - word.length()]) {
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }
    }