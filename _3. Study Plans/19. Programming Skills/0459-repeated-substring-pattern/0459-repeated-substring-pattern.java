class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int i = 1; i <= (n / 2) + 1; i++) {
                if (n % i != 0) {
                    continue;
                }
                int times = n / i;
                if (times >= 2 && s.substring(0, i).repeat(times).equals(s)) {
                    return true;
                }
            }
            return false;
        }
    }