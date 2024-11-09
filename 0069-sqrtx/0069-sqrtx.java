class Solution {
    public int mySqrt(int x) {
            if (x < 2) {
                return x;
            } else if (x == 2) {
                return 1;
            }

            int left = 0;
            int right = x / 2;
            while (left <= right) {
                int curr = (left + right) / 2;
                int prev = curr - 1;
                long currSq = (long) curr * curr;
                long prevSq = (long) prev * prev;
                if (currSq == x) {
                    return curr;
                } else if (currSq > x && prevSq < x) {
                    return prev;
                } else if (currSq > x) {
                    right = curr - 1;
                } else if (currSq < x) {
                    left = curr + 1;
                }
            }

            return right;
        }
}