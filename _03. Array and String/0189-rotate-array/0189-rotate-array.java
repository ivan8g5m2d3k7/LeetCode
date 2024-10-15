class Solution {
    public void rotate(int[] nums, int k) {
//            Input: nums = [1,2,3,4,5,6,7], steps = 3
//            Output: [5,6,7,1,2,3,4]
//            Explanation:
//            rotate 1 steps to the right: [7,1,2,3,4,5,6]
//            rotate 2 steps to the right: [6,7,1,2,3,4,5]
//            rotate 3 steps to the right: [5,6,7,1,2,3,4]

            int steps = k % nums.length;
            int[] first = new int[steps];
            int[] second = new int[nums.length - steps];
            for (int i = 0; i < nums.length - steps; i++) {
                second[i] = nums[i];
            }

            int j = 0;
            for (int i = nums.length - steps; i < nums.length; i++) {
                first[j++] = nums[i];
            }

            for (int i = 0; i < steps; i++) {
                nums[i] = first[i];
            }

            j = 0;
            for (int i = steps; i < nums.length; i++) {
                nums[i] = second[j++];
            }
        }
}