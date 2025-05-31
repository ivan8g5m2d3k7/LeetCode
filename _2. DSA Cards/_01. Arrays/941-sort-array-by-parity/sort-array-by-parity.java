class Solution {
    public int[] sortArrayByParity(int[] nums) {
            int oddCount = 0;
            for (int num : nums) {
                if (num % 2 == 1) {
                    oddCount++;
                }
            }

            int oddIndex = nums.length - oddCount;
            int i = 0;
            while (i < nums.length && oddIndex < nums.length) {
                if (nums[i] % 2 == 1) {
                    int temp = nums[i];
                    nums[i] = nums[oddIndex];
                    nums[oddIndex++] = temp;
                } else {
                    i++;
                }
            }

            return nums;
        }
}