class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            // dp[i] -> can s.substring(0, i) be written with the words in set
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            
            return dp[dp.length - 1];
        }
    }