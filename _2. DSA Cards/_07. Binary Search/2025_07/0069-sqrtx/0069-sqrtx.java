class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            if (x < 4) {
                return 1;
            }

            int left = 0;
            int right = x / 2;

            while (left <= right) {
                int mid = left + ( (right - left) / 2);
                long square = (long) mid * mid;

                if (square == x) {
                    return mid;
                } else if (square < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left - 1;
        }
    }