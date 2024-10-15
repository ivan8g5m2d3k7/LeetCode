class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            List<Integer> result = new ArrayList<>(rows * cols);
            boolean right = true;
            boolean left = false;
            boolean down = false;
            boolean up = false;
            int row = 0;
            int col = 0;
            boolean[][] visited = new boolean[rows][cols];

            for (int c = 0; c < rows * cols; c++) {
                visited[row][col] = true;
                result.add(matrix[row][col]);

                if (right) {
                    if (col + 1 >= cols || visited[row][col + 1]) {
                        right = false;
                        down = true;
                        row++;
                    } else {
                        col++;
                    }
                } else if (down) {
                    if (row + 1 >= rows || visited[row + 1][col]) {
                        down = false;
                        left = true;
                        col--;
                    } else {
                        row++;
                    }
                } else if (left) {
                    if (col - 1 < 0 || visited[row][col - 1]) {
                        left = false;
                        up = true;
                        row--;
                    } else {
                        col--;
                    }
                } else if (up) {
                    if (row - 1 < 0 || visited[row - 1][col]) {
                        up = false;
                        right = true;
                        col++;
                    } else {
                        row--;
                    }
                }
            }

            result.reversed();
            return result;
        }
}