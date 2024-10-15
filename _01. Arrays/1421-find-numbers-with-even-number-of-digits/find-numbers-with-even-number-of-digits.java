class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
            for (int num : nums) {
                String digits = String.valueOf(num);
                if (digits.length() % 2 == 0) {
                    count++;
                }
            }
            
            return count;
    }
}