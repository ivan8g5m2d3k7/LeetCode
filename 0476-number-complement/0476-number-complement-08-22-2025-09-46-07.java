class Solution {
        public int findComplement(int num) {
            int shifts = 32 - Integer.numberOfLeadingZeros(num);
            int complement = 0;
            for (int s = 0; s < shifts; s++) {
                if ( ((num >> s) & 1) == 0 ) {
                    complement |= 1 << s;
                }
            }
            return complement;
        }
    }