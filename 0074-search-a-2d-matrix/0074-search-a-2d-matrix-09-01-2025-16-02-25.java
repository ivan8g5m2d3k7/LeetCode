class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int r = matrix.length;
            int c = matrix[0].length;
            int n = r * c;
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int i = mid / c;
                int j = mid % c;

                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            return false;
        }
    }