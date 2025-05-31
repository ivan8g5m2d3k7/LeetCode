class Solution {
     public int minSubArrayLen(int target, int[] nums) {
            int fast = 0;
            int slow = 0;
            int sum = 0;
            int minLength = Integer.MAX_VALUE;

           while (fast < nums.length) {
               sum += nums[fast++];

               while (sum >= target) {
                   minLength = Math.min(minLength, fast - slow);
                   sum -= nums[slow++];
               }
           }

            if (minLength == Integer.MAX_VALUE) {
                return 0;
            } else {
                return minLength;
            }
        }
}