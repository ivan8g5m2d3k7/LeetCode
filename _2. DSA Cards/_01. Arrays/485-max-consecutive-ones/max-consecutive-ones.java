class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
            int currentMax = 0;
            
            for (int num : nums) {
                if (num == 1) {
                    currentMax++;
                    if (currentMax > max) {
                        max = currentMax;
                    }
                } else {
                    currentMax = 0;
                }
            }
            
            return max;
    }
}