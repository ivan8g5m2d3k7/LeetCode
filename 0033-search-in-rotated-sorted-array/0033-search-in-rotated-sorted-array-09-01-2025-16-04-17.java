class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int minIdx = left;
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int m = left + (right - left) / 2;
                int mid = (m + minIdx) % nums.length;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            }
            return -1;
        }
    }