 class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
                return false;
            }

            for (int i = 0; i < n; i++) {
                if (target > matrix[i][m - 1]) {
                    continue;
                }

                int left = 0;
                int right = m - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return false;
        }
    }