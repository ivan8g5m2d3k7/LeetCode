 class Solution {
        public int search(ArrayReader reader, int target) {
            int left = 0;
            int right = (int) Math.pow(10, 4);

            while (left <= right) {
                int mid = left + (right - left) / 2;

                int num = reader.get(mid);
                if (num == Integer.MAX_VALUE || num > target) {
                    right = mid - 1;
                } else if (num < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }

            return -1;
        }
    }