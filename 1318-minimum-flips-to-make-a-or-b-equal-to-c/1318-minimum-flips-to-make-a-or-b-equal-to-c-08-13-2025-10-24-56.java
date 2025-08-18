class Solution {
        public int minFlips(int a, int b, int c) {
            int flips = 0;
            for (int i = 0; i < 32; i++) {
                int ab = (a >> i) & 1;
                int bb = (b >> i) & 1;
                int cb = (c >> i) & 1;

                /*
              
                0 1 - 0
                0 0 - 1
                1 1 - 0
                
                 */
                if ( (ab | bb) != cb) {
                    if (cb == 0) {
                        if (ab != 0) {
                            flips++;
                        }
                        if (bb != 0) {
                            flips++;
                        }
                    } else {
                        flips++;
                    }
                }
            }

            return flips;
        }
    }