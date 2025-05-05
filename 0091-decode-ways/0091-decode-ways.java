public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // Memoization array. -1 means "not computed yet"
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return dfs(0, s, memo);
    }

    private int dfs(int i, String s, int[] memo) {
        // Base case: reached the end => 1 valid decoding
        if (i == s.length()) {
            return 1;
        }

        // If current digit is '0', it can't be decoded
        if (s.charAt(i) == '0') {
            return 0;
        }

        // If already computed, return memoized value
        if (memo[i] != -1) {
            return memo[i];
        }

        // One-digit decoding
        int ways = dfs(i + 1, s, memo);

        // Two-digit decoding, check if valid (10 to 26)
        if (i + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += dfs(i + 2, s, memo);
            }
        }

        memo[i] = ways;
        return ways;
    }
}
