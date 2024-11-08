class Solution {
    public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> dist(points[b]) - dist(points[a]));
            for (int i = 0; i < points.length; i++) {
                if (i < k) {
                    maxHeap.offer(i);
                } else if (dist(points[i]) < dist(points[maxHeap.peek()])) {
                    maxHeap.poll();
                    maxHeap.offer(i);
                }
            }
            
            int[][] res = new int[k][2];
            for (int i = 0; i < k; i++) {
                int index = maxHeap.poll();
                res[i][0] = points[index][0];
                res[i][1] = points[index][1];
            }
            
            return res;
        }

        public int dist(int[] c) {
            return c[0] * c[0] + c[1] * c[1];
        }
}