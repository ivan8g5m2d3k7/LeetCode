class Solution {
    public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                Set<Character> row = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    char curr = board[i][j];
                    if (curr == '.') {
                        continue;
                    }
                    
                    if (row.contains(curr)) {
                        return false;
                    }
                    
                    row.add(curr);
                }
            }
            
            for (int j = 0; j < 9; j++) {
                Set<Character> col = new HashSet<>();
                for (int i = 0; i < 9; i++) {
                    char curr = board[i][j];
                    if (curr == '.') {
                        continue;
                    }
                    
                    if (col.contains(curr)) {
                        return false;
                    }
                    
                    col.add(curr);
                }
            }
            
            for (int r = 3; r <= 9; r += 3) {
                for (int c = 3; c <= 9; c += 3) {
                    Set<Character> box = new HashSet<>();
                    
                    for (int i = r - 3; i < r; i++) {
                        for (int j = c - 3; j < c; j++) {
                            char curr = board[i][j];
                            if (curr == '.') {
                                continue;
                            }

                            if (box.contains(curr)) {
                                return false;
                            }

                            box.add(curr);
                        }
                    }
                }
            }
            
            return true;
        }
}