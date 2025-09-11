class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int total = 0;
            int max = 0;
            for (int w : weights) {
                total += w;
                max = Math.max(max, w);
            }

            int low = max;
            int high = total;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (!isCapacityEnough(weights, days, mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            
            return low;
        }

        private boolean isCapacityEnough(int[] weights, int days, int capacity) {
            int d = 1;
            int load = 0;
            for (int w : weights) {
                if (load + w > capacity) {
                    d++;
                    if (d > days) {
                        return false;
                    }

                    load = 0;
                    load += w;
                } else {
                    load += w;
                }
            }

            return true;
        }
    }