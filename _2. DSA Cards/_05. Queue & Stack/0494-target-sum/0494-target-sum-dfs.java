class Solution {
    public int findTargetSumWays(int[] nums, int target) {
            int[] res = new int[1];
            
            checkSum(nums, target, 0, 0, res);
            return res[0];
        }

        public void checkSum(int[] nums, int target, int currSum, int index, int[] res) {
            if (index == nums.length) {
                if (currSum == target) {
                    res[0]++;
                }
                return;
            }

            int curr = nums[index];
            checkSum(nums, target, currSum + curr, index + 1, res);
            checkSum(nums, target, currSum - curr, index + 1, res);
        }
}