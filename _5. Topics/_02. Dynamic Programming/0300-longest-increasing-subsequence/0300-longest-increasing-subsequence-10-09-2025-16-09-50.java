class Solution {
        public int lengthOfLIS(int[] nums) {
            //  Input: nums = [10,9,2,5,3,7,101,18] -> 4; [2,3,7,101]
            int length = 0;
            int n = nums.length;
            int[] tails = new int[n];
            Arrays.fill(tails, Integer.MIN_VALUE);

            for (int num : nums) {
                int left = 0;
                int right = length;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                tails[left] = num;
                if (left == length) {
                    length++;
                }
            }

            return length;
        }
    }