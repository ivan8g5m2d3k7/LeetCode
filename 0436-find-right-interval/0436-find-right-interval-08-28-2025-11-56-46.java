class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[][] ascendingA = new int[n][2];
            for (int i = 0; i < n; i++) {
                ascendingA[i][0] = intervals[i][0];
                ascendingA[i][1] = i;
            }
            Arrays.sort(ascendingA, Comparator.comparingInt(x -> x[0]));

            int[] result = new int[n];
//            int[] used = new int[n];

            for (int i = 0; i < n; i++) {
                int end = intervals[i][1];
                int left = 0;
                int right = n;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (ascendingA[mid][0] < end) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left < n) {
                    result[i] = ascendingA[left][1];
                } else {
                    result[i] = -1;
                }
            }

            return result;
        }
    }