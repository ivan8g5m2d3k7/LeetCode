class Solution {
     public int thirdMax(int[] nums) {
            int first = nums[0];
            Integer second = null;
            Integer third = null;

            for (int num : nums) {
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } else if (num != first && (second == null || num > second)) {
                    third = second;
                    second = num;
                } else if (num != first && num != second && (third == null || num > third)) {
                    third = num;
                }
            }

            if (third != null) {
                return third;
            } else {
                return first;
            }
        }
}