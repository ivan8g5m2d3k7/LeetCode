class Solution {
    public int maxArea(int[] height) {
            int res = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                int a = height[left];
                int b = height[right];
                int curr = Math.min(a, b) * (right - left);
                res = Math.max(res, curr);

                if (a <= b) {
                    left++;
                } else {
                    right--;
                }
            }

            return res;
        }
}