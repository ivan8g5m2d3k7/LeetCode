class Solution {
        public String mergeAlternately(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int i = 0;
            int j = 0;
            StringBuilder sb = new StringBuilder(m + n);
            while (i < m || j < n) {
                if (i < m) {
                    sb.append(word1.charAt(i++));
                }
                if (j < n) {
                    sb.append(word2.charAt(j++));
                }
            }
            return sb.toString();
        }
    }