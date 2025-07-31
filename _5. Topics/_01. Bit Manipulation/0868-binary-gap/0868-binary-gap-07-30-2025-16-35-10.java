class Solution {
        public int binaryGap(int n) {
            int last1 = -1;
            int maxDist = 0;

            for (int i = 0; i < 32; i++) {
                int bit = (n >> i) & 1;
                if (last1 == -1 && bit == 1) {
                    last1 = i;
                    continue;
                }

                if (bit == 1) {
                    maxDist = Math.max(maxDist, i - last1);
                    last1 = i;
                }
            }

            return maxDist;
        }
    }