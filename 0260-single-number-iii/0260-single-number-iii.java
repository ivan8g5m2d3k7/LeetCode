class Solution {
     public int[] singleNumber(int[] nums) {
            int both = 0;
            for (int n : nums) {
                both ^= n;
            }

            int first = 0;
            int bit = both & (-both);
            for (int n : nums) {
                if ((n & bit) == bit) {
                    first ^= n;
                }
            }

            int second = both ^ first;
            if (first < second) {
                return new int[]{first, second};
            } else {
                return new int[]{second, first};
            }
        }
}