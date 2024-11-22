class Solution {
    public int removeDuplicates(int[] nums) {
//            Input: nums = [0,0,1,1,1,1,2,3,3]
//            Output: 7, nums = [0,0,1,1,2,3,3,_,_]
            int w = 1;
            int c = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    c++;
                } else {
                    c = 1;
                }

                if (c < 3) {
                    nums[w++] = nums[i];
                }
            }

            return w;
        }
}