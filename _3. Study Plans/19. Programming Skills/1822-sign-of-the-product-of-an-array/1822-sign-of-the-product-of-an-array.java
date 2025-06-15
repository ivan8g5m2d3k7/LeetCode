class Solution {
        public int arraySign(int[] nums) {
            int countNegative = 0;
            for (int a : nums) {
                if (a == 0) {
                    return 0;
                } else if (a < 0) {
                    countNegative++;
                }
            }
            
            return countNegative % 2 == 0 ? 1 : -1;
        }
    }