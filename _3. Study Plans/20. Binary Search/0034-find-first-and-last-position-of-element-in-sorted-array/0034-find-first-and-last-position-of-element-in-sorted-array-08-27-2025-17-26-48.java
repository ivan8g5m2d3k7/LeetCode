class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == nums.length || nums[left] != target) {
                return new int[] {-1, -1};
            }

            int first = left;
            left = 0;
            right = nums.length -1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid; // can this be right = mid - 1 for this problem? Why or why not?
                                //  What about other problems?
                }
            }

            int second = nums[left] == target ? left : left - 1;

            return new int[] {first, second};
        }
    }