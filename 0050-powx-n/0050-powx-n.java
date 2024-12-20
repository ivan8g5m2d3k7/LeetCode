class Solution {
    public double myPow(double x, int n) {
            if (n < 0) {
                return 1 / Math.pow(x, (long) -1 * n);
            }
            if (n == 0) {
                return 1.0;
            }

            return Math.pow(x, (long) n);
        }
}