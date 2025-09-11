class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int low = 1;
            int high = Arrays.stream(nums).max().getAsInt();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (!isResultValid(nums, threshold, mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }

        private boolean isResultValid(int[] nums, int t, int d) {
            int sum = 0;
            for (int a : nums) {
                sum += (int) Math.ceil((double) a / d);
            }

            return sum <= t;
        }
    }