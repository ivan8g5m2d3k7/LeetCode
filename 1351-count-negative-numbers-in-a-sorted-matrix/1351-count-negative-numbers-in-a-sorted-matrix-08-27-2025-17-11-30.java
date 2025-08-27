class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                int left = 0;
                int right = n;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (grid[i][mid] >= 0) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                
                count += n - left;
            }
            
            return count;
        }
    }