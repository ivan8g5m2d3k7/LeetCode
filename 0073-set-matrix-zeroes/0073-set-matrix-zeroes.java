class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> zeroRows = new HashSet<>(matrix.length);
            Set<Integer> zeroCols = new HashSet<>(matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRows.add(i);
                        zeroCols.add(j);
                    }
                }
            }
            
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (zeroRows.contains(i) || zeroCols.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }