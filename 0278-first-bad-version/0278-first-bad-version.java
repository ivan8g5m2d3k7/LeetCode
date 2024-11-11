/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
                // API bool isBadVersion(version)
                if (n == 1) {
                    return n;
                }
                int left = 1, right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (!isBadVersion(mid) && isBadVersion(mid + 1)) {
                        return mid + 1;
                    } else if (mid - 1 > 0 && isBadVersion(mid) && !isBadVersion(mid - 1)) {
                        return mid;
                    } else if (!isBadVersion(mid)) {
                        left = mid + 1;
                    } else if (isBadVersion(mid)) {
                        right = mid;
                    }
                }

                if (!isBadVersion(left - 1) && isBadVersion(left)) {
                    return left;
                } else {
                    return -1;
                }
            }
}