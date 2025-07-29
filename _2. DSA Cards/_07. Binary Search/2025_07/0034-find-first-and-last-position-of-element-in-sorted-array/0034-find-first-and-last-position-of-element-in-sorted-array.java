class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[] {-1, -1};
            }
            if (nums.length == 1 && nums[0] == target) {
                return new int[] {0, 0};
            }

            //  nums = [5,7,7,8,8,10], target = 8
            int left = 0;
            int right = nums.length - 1;

            //  first index
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] >= target) {
                    right = mid;
                }
            }

            int firstIndex = left;
            if (nums[firstIndex] != target) {
                return new int[] {-1, -1};
            }

            //  last index
            left = 0;
            right = nums.length - 1;
            int lastIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) {
                        left = mid + 1;
                    } else {
                        lastIndex = mid;
                        break;
                    }
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }

            return new int[] {firstIndex, lastIndex};
        }
    }