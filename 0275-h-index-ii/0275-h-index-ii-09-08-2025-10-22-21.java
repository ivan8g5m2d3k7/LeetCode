class Solution {
        public int hIndex(int[] citations) {
            //   citations = [0,1,3,5,6]
            int left = 0;
            int right = citations.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int num = citations[mid] - (citations.length - mid);

                if (num < 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return citations.length - left;
        }
    }