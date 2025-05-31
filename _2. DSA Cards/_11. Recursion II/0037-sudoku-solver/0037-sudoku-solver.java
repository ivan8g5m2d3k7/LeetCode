class Solution {
    private boolean[][] rows = new boolean[9][10];
       private boolean[][] cols = new boolean[9][10];
       private boolean[][] boxes = new boolean[9][10];

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }

                    int num = board[i][j] - '0';
                    int b = 3 * (i / 3) + (j / 3);
                    boxes[b][num] = true;
                    rows[i][num] = true;
                    cols[j][num] = true;
                }
            }

            fill(board, 0, 0);
        }

        public boolean fill(char[][] board, int i, int j) {
            if (j >= 9) {
                return fill(board, i + 1, 0);
            }
            if (i >= 9) {
                return true;
            }
            if (board[i][j] != '.') {
                return fill(board, i, j + 1);
            }

            int b = 3 * (i / 3) + (j / 3);
            for (int x = 1; x < 10; x++) {
                if (!boxes[b][x] && !rows[i][x] && !cols[j][x]) {
                    board[i][j] = (char) (x + '0');
                    boxes[b][x] = true;
                    rows[i][x] = true;
                    cols[j][x] = true;

                    if (fill(board, i, j + 1)) {
                        return true;
                    }

                    board[i][j] = '.';
                    boxes[b][x] = false;
                    rows[i][x] = false;
                    cols[j][x] = false;
                }
            }

            return false;
        }
}