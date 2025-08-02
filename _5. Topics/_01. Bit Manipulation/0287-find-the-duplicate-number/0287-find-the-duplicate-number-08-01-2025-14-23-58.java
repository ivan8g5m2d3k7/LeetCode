class Solution {
        public int findDuplicate(int[] nums) {
            int duplicate = 0;
            for (int i = 0; i < 32; i++) {
                int sequence = 0;
                for (int j = 1; j <= nums.length - 1; j++) {
                    if ( ( (j >> i) & 1) != 0) {
                        sequence++;
                    }
                }

                int array = 0;
                for (int num : nums) {
                    if ( ( (num >> i) & 1) != 0) {
                        array++;
                    }
                }

                if (array > sequence) {
                    duplicate |= (1 << i);
                }
            }

            return duplicate;
        }
    }