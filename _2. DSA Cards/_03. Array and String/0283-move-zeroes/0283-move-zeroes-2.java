class Solution {
     public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j++] = nums[i];
                }
            }
            
            int zeros = nums.length - j;
            for (int i = nums.length - zeros; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
}