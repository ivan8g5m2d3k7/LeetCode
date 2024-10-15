class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;
            int size = rows * cols;
            int[] array = new int[size];
            int i = 0;
            int j = 0;
            boolean upward = true;

            for (int c = 0; c < size; c++) {
                if (i >= rows || j >= cols) {
                    System.out.println("ij: " + i + ": " + j);
                    return array;
                }

                array[c] = mat[i][j];

                if (upward) {
                    if (j == cols - 1) {
                        i++;
                        upward = false;
                    } else if (i == 0) {
                        j++;
                        upward = false;
                    } else {
                        i--;
                        j++;
                    }
                } else {
                    if (i == rows - 1) {
                        j++;
                        upward = true;
                    } else if (j == 0) {
                        i++;
                        upward = true;
                    } else {
                        i++;
                        j--;
                    }
                }
            }

            return array;
        }
}