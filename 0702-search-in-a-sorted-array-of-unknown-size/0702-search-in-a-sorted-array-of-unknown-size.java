/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
   public int search(ArrayReader reader, int target) {
            // right < 10^4 = 10 000
            int left = 0, right = 10000;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int curr = reader.get(mid);
                if (curr == target) {
                    return mid;
                } else if (curr < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
}