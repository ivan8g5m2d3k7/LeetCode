class Solution {
        public boolean isMonotonic(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            Boolean isLarger = null;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (isLarger == null) {
                        isLarger = false;
                    } else if (isLarger) {
                        return false;
                    }
                } else if (nums[i] > nums[i - 1]) {
                    if (isLarger == null) {
                        isLarger = true;
                    } else if (!isLarger) {
                        return false;
                    }
                }
            }
            
            return true;
        }
    }