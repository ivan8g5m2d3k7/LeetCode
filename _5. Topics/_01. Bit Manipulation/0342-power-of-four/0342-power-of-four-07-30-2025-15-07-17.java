class Solution {
        public boolean isPowerOfFour(int n) {
            if (n == 1) {
                return true;
            }
            if (n < 4 || Integer.bitCount(n) != 1) {
                return false;
            }
            boolean flag = false;

            for (int i = 2; i < 32; i++) {
                if ( (n & (1 << i)) == 1 && i % 2 != 0) {
                    return false;
                }
            }

            return true;
        }
    }