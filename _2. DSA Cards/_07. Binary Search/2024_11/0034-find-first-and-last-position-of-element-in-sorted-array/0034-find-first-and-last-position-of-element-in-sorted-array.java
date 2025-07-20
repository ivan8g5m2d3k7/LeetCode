class Solution {
    public int[] searchRange(int[] nums, int target) {
                int left = 0, right = nums.length - 1, first = -1, last = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] == target) {
                        first = mid;
                        last = mid;
                        while (first - 1 >= 0 && nums[first - 1] == target) {
                            first--;
                        }
                        while (last + 1 <= nums.length - 1 && nums[last + 1] == target) {
                            last++;
                        }
                        break;
                    } else if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                return new int[] {first, last};
            }
}