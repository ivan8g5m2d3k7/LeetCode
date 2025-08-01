class Solution {
        public char findTheDifference(String s, String t) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                mask ^= c;
            }
            for (char c : t.toCharArray()) {
                mask ^= c;
            }
            
            return (char) mask;
        }
    }