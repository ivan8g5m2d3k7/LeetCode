class Solution {
      public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int zeros = 0;
            int left = 0;
            int right = 0;

            while (right < nums.length) {
                if (nums[right] == 0) {
                    zeros++;
                }

                while (zeros >= 2) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }

                if (max < right - left + 1) {
                    max = right - left + 1;
                }
                right++;
            }

            return max;
        }
}