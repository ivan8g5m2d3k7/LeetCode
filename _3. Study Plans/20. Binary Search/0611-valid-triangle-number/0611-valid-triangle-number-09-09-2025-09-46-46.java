class Solution {
        public int triangleNumber(int[] nums) {
            //  Input: nums = [2,2,3,4]
            Arrays.sort(nums);
            int count = 0;

            for (int k = nums.length - 1; k > 1; k--) {
                int i = 0;
                int j = k - 1;
                while (i < j) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count += j - i;
                        j--;
                    } else {
                        i++;
                    }
                }
            }

            return count;
        }
    }