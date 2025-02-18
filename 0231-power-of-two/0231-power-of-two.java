class Solution {
    public boolean isPowerOfTwo(int n) {
            return n == 1 || Long.bitCount(n) == 1;
        }
}