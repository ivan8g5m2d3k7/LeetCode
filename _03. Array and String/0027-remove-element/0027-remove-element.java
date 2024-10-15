class Solution {
    public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            } 

            int left = 0;
            int right = nums.length - 1;
            int count = 0;

            while (left < right) {
                if (nums[left] != val) {
                    left++;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right--] = temp;
                    count++;
                }
            }

            if (nums[left] == val) {
                count++;
            }

            return nums.length - count;
        }
}