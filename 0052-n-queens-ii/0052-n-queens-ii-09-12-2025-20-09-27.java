class Solution {
        public int totalNQueens(int n) {
            int all = (1 << n) - 1;
            return placeQueens(n, 0, 0, 0, 0, all);
        }
        
        public int placeQueens(int n, int row, int col, int dr, int dl, int all) {
            if (row == n) {
                return 1;
            }
            
            int available = all & ~(col | dr | dl);
            int count = 0;
            for (int a = available; a != 0; a &= a - 1) {
                int bit = a & -a;
                //  int p = Integer.numberOfTrailingZeros(bit) + 1;
                int ncol = col | bit;
                int ndr = ( (dr | bit) << 1) & all;
                int ndl = ( (dl | bit) >> 1) & all;
                
                count += placeQueens(n, row + 1, ncol, ndr, ndl, all);
            }
            
            return count;
        }
    }