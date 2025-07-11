 class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 1) {
                return s;
            }
            
            int longest = 1;
            int center = 0;

            for (int i = 0; i < n; i++) {
                int length1 = findLength(s, i, i);
                int length2 = findLength(s, i, i + 1);
                int length = Math.max(length1, length2);
                
                if (length > longest) {
                    longest = length;
                    center = i;
                }
            }
            
            int start = 0;
            int end = 0;
            
            if (longest % 2 == 1) {
                start = center - (longest / 2);
                end = center + (longest / 2);
            } else {
                start = center - ((longest / 2) - 1);
                end = center + (longest / 2);
            }
            
            return s.substring(start, end + 1);
        }
        
        public int findLength(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return j - i - 1;
        }
    }