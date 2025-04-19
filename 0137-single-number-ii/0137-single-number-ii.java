class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int bit = 0;
                for (int num : nums) {
                    bit += (num >> i) & 1;
                }

                bit %= 3;

                result |= bit << i;
            }

            return result;
        }
    }