class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int mask = n;
            for (int i = 0; i < n; i++) {
                mask ^= i ^ nums[i];
            }
            
            return mask;
        }
    }