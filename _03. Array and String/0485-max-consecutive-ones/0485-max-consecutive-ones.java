class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int current = 0;
            int left = 0;
            int right = 0;

            while (left < nums.length) {
                current = 0;
                
                if (nums[left] == 0) {
                    left++;
                } else {
                    right = left;
                    while (right < nums.length && nums[right] == 1) {
                        current++;
                        right++;
                    }

                    left = right;
                }

                if (max < current) {
                    max = current;
                }
            }

            return max;
        }
}