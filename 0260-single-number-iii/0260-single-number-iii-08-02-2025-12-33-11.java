class Solution {
        public int[] singleNumber(int[] nums) {
            int array = 0;
            for (int num : nums) {
                array ^= num;
            }
            
            int differentBit = array & (-array);
            int a = 0;
            
            for (int num : nums) {
                if ((num & differentBit) != 0) {
                     a ^= num;
                }
            }
            
            int b = array ^ a;
            
            return new int[] {a, b};
        }
    }