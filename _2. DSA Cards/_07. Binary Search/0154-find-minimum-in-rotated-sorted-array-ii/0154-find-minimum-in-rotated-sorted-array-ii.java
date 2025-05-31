class Solution {
     public int findMin(int[] nums) {
//            Input: nums = [2,2,2,0,1], [3,3,3,3,3,3,3,1,3], [1,3,3], [10,1,10,10,10], [1,1], [1,1,1,1,1], [2,2,2,0,2,2], [2,0,2,2,2,2]
//            Output: 0
//            [3,3,3,3,3,3,3,1,3], [3,3,1,3,3,3,3,3,3], [1,2,3], [1,1,2,1,1], [1,1,0,1,1]
            int left = 0, right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }

           return nums[left];
        }
}