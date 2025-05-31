class Solution {
    public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
            int c = 1;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int curr = matrix[i][j];
                    if (c <= k) {
                        maxHeap.offer(curr);
                    } else if (curr < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(curr);
                    }
                    
                    c++;
                }
            }
            
            return maxHeap.peek();
        }
}