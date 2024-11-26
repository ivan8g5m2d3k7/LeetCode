class Solution {
    public boolean isPerfectSquare(int num) {
            int left = 1, right = num / 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                long square = (long) mid * mid;
                if (square < (long) num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return (left - 1) * (left - 1) == num || left * left == num;
        }
}