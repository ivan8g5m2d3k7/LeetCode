class Solution {
    public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
           PriorityQueue<Integer> minHeap = new PriorityQueue<>(m * m);
           for (int i = 0; i < m; i++) {
               for (int j = 0; j < m; j++) {
                   minHeap.offer(matrix[i][j]);
               }
           }
           for (int i = 1; i <= k - 1; i++) {
               minHeap.poll();
           }
           
           return minHeap.poll();
        }
}