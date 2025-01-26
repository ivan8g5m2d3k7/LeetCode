class Solution {
    public String convert(String s, int numRows) {
            boolean one = false;
            Character[][] grid = new Character[numRows][s.length()];
            int i = 0;
            int col = 0;


            while (i < s.length()) {

                if (one) {
                    int indent = numRows - 2;
                    while (indent > 0 && i < s.length()) {
                        grid[indent][col] = s.charAt(i++);
                        indent--;
                        col++;
                    }
                    one = false;
                } else {
                    int r = 0;
                    while (r < numRows && i < s.length()) {
                        grid[r++][col] = s.charAt(i++);
                    }
                    one = true;
                    col++;
                }
            }

            StringBuilder sb = new StringBuilder(s.length());
            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] != null) {
                        sb.append(grid[r][c]);
                    }
                }
            }

            return sb.toString();
        }
}