class Solution {
    public List<Integer> getRow(int rowIndex) {
            int[][] matrix = new int[rowIndex + 1][rowIndex + 1];
            List<Integer> list = new ArrayList<>(rowIndex + 1);
            for (int i = 0; i < rowIndex + 1; i++ ) {
                list.add(calculate(rowIndex, i, matrix));
            }
            return list;
        }

        public int calculate(int row,int col, int[][] matrix) {
            if (col == 0 || row == col) {
                return 1;
            }
            if (matrix[row][col] != 0) {
                return matrix[row][col];
            }

            int num = calculate(row - 1, col - 1, matrix) + calculate(row - 1, col, matrix);
            matrix[row][col] = num;
            return num;
        }
}