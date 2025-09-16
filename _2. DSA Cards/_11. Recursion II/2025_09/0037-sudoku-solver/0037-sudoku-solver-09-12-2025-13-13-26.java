class Solution {
        public void solveSudoku(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            int[] rows = new int[9];
            int[] cols = new int[9];
            int[] boxes = new int[9];
            int full = 0b1_1111_1111;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }

                    int num = Integer.parseInt(String.valueOf(board[i][j]));
                    int b = ( (i / 3) ) * 3 + (j / 3);
                    boxes[b] |= 1 << (num - 1);
                    rows[i] |= 1 << (num - 1);
                    cols[j] |= 1 << (num - 1);
                }
            }

            dfs(board, n, m, rows, cols, boxes, 0, 0);
        }

        public boolean dfs(char[][] board, int n, int m, int[] rows, int[] cols, int[] boxes, int r, int c) {
            if (r == n) {
                return true;
            }
            if (c == m) {
                return dfs(board, n, m, rows, cols, boxes, r + 1, 0);
            }
            if (board[r][c] != '.') {
                return dfs(board, n, m, rows, cols, boxes, r, c + 1);

            }

            int b = ( (r / 3) ) * 3 + (c / 3);
            for (int a = 1; a <= 9; a++) {
                if ( ( ( boxes[b] >> (a - 1) ) & 1) == 1 ||
                        ( rows[r] >> (a - 1) & 1) == 1 ||
                        ( cols[c] >> (a - 1) & 1) == 1) {
                    continue;
                }

                board[r][c] = (char) ('0' + a);
                boxes[b] |= 1 << (a - 1);
                rows[r] |= 1 << (a - 1);
                cols[c] |= 1 << (a - 1);

                if (dfs(board, n, m, rows, cols, boxes, r, c + 1)) {
                    return true;
                }

                board[r][c] = '.';
                boxes[b] &= ~( 1 << (a - 1) );
                rows[r] &= ~( 1 << (a - 1) );
                cols[c] &= ~( 1 << (a - 1) );
            }

            return false;
        }
    }