 class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] lcs = new int[m + 1][n + 1];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        lcs[i + 1][j + 1] = lcs[i][j] + 1;
                    } else {
                        lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
                    }
                }
            }
            
            return lcs[m][n];
        }
    }