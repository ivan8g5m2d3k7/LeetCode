class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            //  [4,5,6,7,0,1,2]

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[left] > nums[right]) {
                    if (nums[mid] < nums[right]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
            
            return nums[left];
        }
    }