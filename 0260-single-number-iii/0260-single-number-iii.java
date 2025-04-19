class Solution {
        public int[] singleNumber(int[] nums) {
            int bitmask = 0;
            for (int num : nums) {
                bitmask ^= num;
            }
            
            int diff = bitmask & -bitmask;
            int x = 0;
            for (int num : nums) {
                if ((num & diff) != 0) {
                    x ^= num;
                }
            }
            
            int y = bitmask ^ x;
            
            return new int[] {x, y};
        }
    }