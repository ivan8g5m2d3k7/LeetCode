class Solution {
        public int reverseBits(int n) {
            int reversed = 0;
            for (int i = 0; i < 32; i++) {
                reversed = reversed << 1;
                reversed |= (n >> i) & 1;
            }

            return reversed;
        }
    }