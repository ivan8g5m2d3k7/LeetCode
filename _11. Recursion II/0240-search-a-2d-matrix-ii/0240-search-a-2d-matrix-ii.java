class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
}

private boolean search(int[][] matrix, int target, int rs, int re, int cs, int ce) {
    // Base case: if the submatrix is invalid
    if (rs > re || cs > ce) {
        return false;
    }

    // Find the midpoint
    int i = rs + (re - rs) / 2;
    int j = cs + (ce - cs) / 2;
    int curr = matrix[i][j];

    // Check the midpoint
    if (curr == target) {
        return true;
    } else if (curr > target) {
        // Search the top-left and top-right submatrices
        return search(matrix, target, rs, i - 1, cs, j - 1) ||  // Top-left quadrant
               search(matrix, target, rs, i - 1, j, ce) ||     // Top-right quadrant
               search(matrix, target, i, re, cs, j - 1);       // Bottom-left quadrant
    } else {
        // Search the bottom-right and bottom-left submatrices
        return search(matrix, target, i + 1, re, j + 1, ce) || // Bottom-right quadrant
               search(matrix, target, i + 1, re, cs, j) ||    // Bottom-left quadrant
               search(matrix, target, rs, i, j + 1, ce);      // Top-right quadrant
    }
}
}