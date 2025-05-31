class Solution {
     public int pivotIndex(int[] nums) {
            int length = nums.length;
            int[] leftSum = new int[length];
            int[] rightSum = new int[length];
            leftSum[0] = 0;
            rightSum[length - 1] = 0;
            int sum = 0;

            for (int i = 1; i < length; i++) {
                sum += nums[i];
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
                rightSum[length - i - 1] = rightSum[length - i] + nums[length - i];
            }
            rightSum[0] = sum;

            for (int i = 0; i < length; i++) {
                if (leftSum[i] == rightSum[i]) {
                    return i;
                }
            }

            return -1;
        }
}