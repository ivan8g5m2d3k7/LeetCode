 class Solution {
        public int uniquePaths(int m, int n) {
            int[][] memo = new int[m][n];
            return traverse(m, n, m - 1, n - 1, memo);
        }
        
        public int traverse(int m, int n, int i, int j, int[][] memo) {
            if (i == 0 || j == 0) {
                return 1;
            }
            
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            
            int num = traverse(m, n, i - 1, j, memo) + traverse(m, n, i, j - 1, memo);
            memo[i][j] = num;
            return num;
        } 
    }