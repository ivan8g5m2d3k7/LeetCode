class Solution {
    public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] + nums[i] == target) {
                        result[0] = j;
                        result[1] = i;
                        return result;
                    }
                }
            }
            
            return result;
        }
}