class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            boolean[][] used = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        used[i][j] = true;

                        if (search(board, word, 0, i, j, used)) {
                            return true;
                        }

                        used[i][j] = false;
                    }
                }
            }

            return false;
        }

        private boolean search(char[][] board, String word, int index, int r, int c,
                               boolean[][] used) {
            if (word.charAt(index) != board[r][c]) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            
            int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
            for (int[] d : directions) {
                int row = r + d[0];
                int col = c + d[1];
                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length &&
                        !used[row][col]) {
                    used[row][col] = true;

                    if (search(board, word, index + 1, row, col, used)) {
                        return true;
                    }

                    used[row][col] = false;
                }
            }

            return false;
        }
    }