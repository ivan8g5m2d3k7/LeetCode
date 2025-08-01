class Solution {
        public boolean hasAlternatingBits(int n) {
            String string = Integer.toBinaryString(n);
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) == string.charAt(i - 1)) {
                    return false;
                }
            }
            
            return true;
        }
    }