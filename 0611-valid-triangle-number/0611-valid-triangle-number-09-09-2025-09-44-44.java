class Solution {
        public int triangleNumber(int[] nums) {
            //  Input: nums = [2,2,3,4]
            Arrays.sort(nums);
            int count = 0;
            for (int k = nums.length - 1; k > 1; k--) {
                for (int j = k - 1; j > 0; j--) {
                    int left = 0;
                    int right = j;
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] + nums[j] <= nums[k]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    if (left < j) {
                        while (left > 0 && nums[left] == nums[left - 1]) {
                            left--;
                        }
                        count += j - left;
                    }
                }
            }
            return count;
        }
    }