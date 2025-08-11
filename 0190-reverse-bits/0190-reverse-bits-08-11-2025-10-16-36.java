class Solution {
        public int reverseBits(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                if ( ( (n >> i) & 1) == 0) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
            
            return Integer.parseInt(sb.toString(), 2);
        }
    }